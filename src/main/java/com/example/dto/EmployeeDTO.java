package com.example.dto;

import com.example.model.Employee;
import com.example.utils.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDTO {
    private final SessionFactory sessionFactory;

    public EmployeeDTO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void Create(String name, int age) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
    }

    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        System.out.println(employee);
        session.close();
        return employee;
    }

    public List<Employee> getAllEmployeesHQL() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("from Employee").list();
        session.getTransaction().commit();
        session.close();
        System.out.println(employees);
        return employees;
    }

    public List<Employee> getAllEmployeesCriteriaAPI() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        List<Employee> employees = session.createQuery(cq).getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println(employees);
        return employees;
    }

    public List<Employee> getAllEmployeesWithName(String name) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root).where(cb.equal(root.get("name"), name));
        List<Employee> employees = session.createQuery(cq).getResultList();
        System.out.println(employees);
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    public void deleteEmployeeById(int id) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Employee> cd = cb.createCriteriaDelete(Employee.class);
        Root<Employee> root = cd.from(Employee.class);
        cd.where(cb.equal(root.get("id"), id));
        int numberOfRowsDeleted = session.createQuery(cd).executeUpdate();
        System.out.println("Number of rows deleted: " + numberOfRowsDeleted);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteAllEmployeesByName(String name) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<Employee> cd = cb.createCriteriaDelete(Employee.class);
        Root<Employee> root = cd.from(Employee.class);
        cd.where(cb.equal(root.get("name"), name));
        int numberOfRowsDeleted = session.createQuery(cd).executeUpdate();
        System.out.println("Number of rows deleted: " + numberOfRowsDeleted);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUsingCriteriaAPI(int id) {

    }

    public void tearDown() {
        this.sessionFactory.close();
    }
}

