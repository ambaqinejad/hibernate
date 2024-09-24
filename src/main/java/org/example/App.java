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
        // employeeDTO.Create("Hassan", 29);
        // employeeDTO.Create("Mohammad", 31);

        // READ BY ID
        employeeDTO.getEmployeeById(1);

        // READ ALL
        employeeDTO.getAllEmployeesHQL();
        employeeDTO.getAllEmployeesCriteriaAPI();
        employeeDTO.getAllEmployeesGreaterThanSpecificAge(30);
        employeeDTO.getCountOfAllEmployeesGreaterThanSpecificAge(30);

        // READ ALL WITH NAME
        employeeDTO.getAllEmployeesWithName("Hossein");

        // UPDATE
        employeeDTO.updateUsingCriteriaAPI(3, "Ali", 30);
        employeeDTO.updateUsingPreparedMethod(7, "Hassan", 20);
        employeeDTO.updateAgeOfAllEmployeesWithSpecificName("Hassan", 19);
        employeeDTO.updateUsingHQL(3, "Karim", 40);

        // DELETE BY ID
        employeeDTO.deleteEmployeeById(1);

        // DELETE ALL BY NAME
        employeeDTO.deleteAllEmployeesByName("Hossein");
        employeeDTO.tearDown();
    }
}
