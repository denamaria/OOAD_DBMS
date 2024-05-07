package com.ilp03.service;

import java.util.List;
import com.ilp03.entity.Employee;

public interface EmployeeService {
    List<Employee> getExcellentPerformers();
    List<Employee> getPoorPerformers();
}
