package org.example;

import com.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Create a SessionFactory from hibernate.cfg.xml
        try (SessionFactory factory = new Configuration().configure("hibernate/hibernate.cfg.xml").buildSessionFactory()) {
            // Obtain a session
            Session session = factory.openSession();
            session.beginTransaction();
            Employee employee = new Employee(1, "Amir", 28);
            session.save(employee);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
