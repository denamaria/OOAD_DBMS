package com.ilp03.service;

import java.util.List;
import com.ilp03.dao.EmployeeDAO;
import com.ilp03.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO; 

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    
    public List<Employee> getExcellentPerformers() {
        return employeeDAO.getEmployeesByPerformance("Excellent");
    }

    
    public List<Employee> getPoorPerformers() {
        return employeeDAO.getEmployeesByPerformance("Poor");
    }
}
