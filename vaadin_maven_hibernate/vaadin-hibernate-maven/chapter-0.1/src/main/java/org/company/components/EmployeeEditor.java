package org.company.components;


import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import org.company.DAO.EmployeeDAO;
import org.company.database.Employee;


public class EmployeeEditor extends VerticalLayout implements KeyNotifier {
    private EmployeeDAO employeeDAO = null;

    private Employee employee;

    private  final TextField IdEmp = new TextField("Id emp");
    private final TextField firstName = new TextField("First name");
    private final TextField lastName = new TextField("Last name");
    private final TextField email = new TextField("Email");
    private final TextField salary = new TextField("Salary");

    private final Button save = new Button("Save", VaadinIcon.CHECK.create());
    private final Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    private final HorizontalLayout actions = new HorizontalLayout(save, delete);

    private final Binder<Employee> binder = new Binder<>(Employee.class);

    private ChangerHandler changerHandler;

    public void setChangerHandler(ChangerHandler changerHandler) {
        this.changerHandler = changerHandler;
    }

    public interface ChangerHandler {
        void onChange();
    }
    public EmployeeEditor(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;

        add(IdEmp, lastName, firstName, email, salary, actions);

        binder.forField(IdEmp).withConverter(
                new StringToIntegerConverter("Please enter a number")
        ).bind("idEmp");
        binder.bind(firstName, Employee::getName, Employee::setName);
        binder.bind(lastName, Employee::getSurname, Employee::setSurname);
        binder.bind(email, Employee::getEmail, Employee::setEmail);
        binder.forField(salary).withConverter(
                new StringToIntegerConverter("Please enter a number")
        ).bind("salary");

       //binder.bindInstanceFields(this);

        setSpacing(true);

        save.getElement().getThemeList().add("primaty");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e-> save());

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        setVisible(false);
    }
    public void save() {
        employeeDAO.create(employee);
        changerHandler.onChange();
    }
    public void delete() {
        employeeDAO.delete(employee);
        changerHandler.onChange();
    }
    public  void editEmployee(Employee emp) {
        if(emp == null) {
            setVisible(false);
            return;
        }
        if(emp.getIdEmp() != 0) {
            employee = employeeDAO.read(emp.getIdEmp());
            if(this.employee == null) {
                employeeDAO.create(emp);
                employee = employeeDAO.read(emp.getIdEmp());
            }
        }
        else {
            employee = emp;
        }
        binder.setBean(employee);

        setVisible(true);

        lastName.focus();

    }
}
