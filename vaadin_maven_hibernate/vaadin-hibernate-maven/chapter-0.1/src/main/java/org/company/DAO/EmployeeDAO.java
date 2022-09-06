package org.company.DAO;

import org.company.database.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAO implements DAO<Employee, Integer>{
    private final SessionFactory factory;

    public EmployeeDAO(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(final Employee employee) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }
    @Override
    public Employee read(final Integer idEmp) {
        try (final Session session = factory.openSession()) {
            return session.get(Employee.class, idEmp);
        }
    }

    @Override
    public void update(final Employee employee) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(final Employee employee) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        }
    }
    public List getList() {
        List<Employee> list = null;
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            list = session.createQuery("from Employee").list();
            session.getTransaction().commit();
        }
        return list;
    }
    public List getList(String search) {
        List<Employee> list = null;
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Employee e " +
                    "where concat(e.surname, ' ', e.name)" +
                    "   like concat('%', '" + search + "', '%') ");
            list =  query.list();
            session.getTransaction().commit();
        }
        return list;
    }
}