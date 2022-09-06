package org.company;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.company.DAO.EmployeeDAO;
import org.company.components.EmployeeEditor;
import org.company.database.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * The main view contains a button and a click listener.
 */
@Route
public class MainView extends VerticalLayout {

    private final Grid<Employee> grid = new Grid<>(Employee.class, false);

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    EmployeeDAO employeeDAO = new EmployeeDAO(factory);

    private final TextField filder = new TextField("", "seach");
    private final Button addNewBtn = new Button("Add new");
    private final EmployeeEditor editor  = new EmployeeEditor(employeeDAO);
    private final HorizontalLayout toolbar = new HorizontalLayout(filder, addNewBtn);
    public MainView() {

        grid.addColumn(Employee::getIdEmp).setHeader("Id");
        grid.addColumn(Employee::getName).setHeader("First name");
        grid.addColumn(Employee::getSurname).setHeader("Last name");
        grid.addColumn(Employee::getEmail).setHeader("Date emp");
        grid.addColumn(Employee::getSalary).setHeader("Salary");

        add(toolbar, grid, editor);

        filder.setValueChangeMode(ValueChangeMode.EAGER);
        filder.addValueChangeListener(e -> printEmployee(e.getValue()));

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editEmployee(e.getValue());
        });

        addNewBtn.addClickListener((e -> editor.editEmployee(new Employee())));

        editor.setChangerHandler(() -> {
            editor.setVisible(false);
            printEmployee(filder.getValue());
        });

        printEmployee("");
    }
    private void printEmployee(String search) {
        if(search .isEmpty()) {
            grid.setItems(employeeDAO.getList());
        }
        else {
            grid.setItems(employeeDAO.getList(search));
        }
    }
}