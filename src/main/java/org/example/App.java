package org.example;

import com.example.dto.EmployeeDTO;
import com.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        // CREATE
        employeeDTO.Create("Hossein", 28);

        // READ BY ID
        employeeDTO.getEmployeeById(1);

        // READ ALL
        employeeDTO.getAllEmployeesHQL();
        employeeDTO.getAllEmployeesCriteriaAPI();

        // READ ALL WITH NAME
        employeeDTO.getAllEmployeesWithName("Hossein");

        // DELETE BY ID
        employeeDTO.deleteEmployeeById(1);

        // DELETE ALL BY NAME
        employeeDTO.deleteAllEmployeesByName("Hossein");
        employeeDTO.tearDown();
    }
}
