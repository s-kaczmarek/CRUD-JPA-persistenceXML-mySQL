package controller;

import domain.Employee;
import domain.EmployeeRepository;

import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in);

    public void addNewEmployee(){
        
        System.out.println("First Name: ");
        String firstName = scanner.next();
        System.out.println("Last Name: ");
        String lastName = scanner.next();
        System.out.println("Salary1: ");
        double salary1 = scanner.nextDouble();
        System.out.println("Salary2: ");
        String salary2String = scanner.next();
        System.out.println("City: ");
        String locality = scanner.next();
        System.out.println("Zip Code: ");
        String zipCode = scanner.next();
        System.out.println("Street: ");
        String street = scanner.next();
        System.out.println("House number: ");
        int streetNumber = scanner.nextInt();

        Employee newEmployee = new Employee(firstName, lastName, salary1, salary2String, locality, zipCode, street, streetNumber);
        EmployeeRepository.addNewEmployeeFromCLI(newEmployee);

    }
}
