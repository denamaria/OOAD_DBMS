package com.ilp03.utility;

import com.ilp03.dao.EmployeeDAO;
import com.ilp03.entity.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeUtility {

    private final EmployeeDAO employeeDAO;

    public EmployeeUtility(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void startUtility() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Print Excellent Performing Employees");
            System.out.println("2. Print Poor Performing Employees");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printEmployeesByPerformance("Excellent");
                    break;
                case 2:
                    printEmployeesByPerformance("Poor");
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
    private void printEmployeesByPerformance(String performance) {
        List<Employee> employees = employeeDAO.getEmployeesByPerformance(performance);

        if (employees.isEmpty()) {
            System.out.println("No employees found for " + performance + " performance.");
        } else {
            System.out.println("Employees with " + performance + " performance:");
            for (Employee employee : employees) {
                System.out.println("First Name: " + employee.getFirstName());
                System.out.println("Last Name: " + employee.getLastName());
                System.out.println("Department Name: " + employee.getDepartmentName());
                System.out.println();
            }
        }
    }}
