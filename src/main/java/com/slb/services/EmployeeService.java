package com.slb.services;

import com.slb.daos.EmployeeRepository;
import com.slb.domains.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface EmployeeService {

    Employee getEmployeeByName(String name);

    Employee getEmployeeById(String id);

    Set<Employee> getEmployeesByDept(String department);

    Employee save(Employee employee);

    Employee calculateGrossWage(Employee employee);

    Employee calculateNetWage(Employee employee);

    Employee updateTotalDebitBalance(Employee employee);

    Employee update(Employee employee);

    Boolean delete(String id);

    Set<Employee> getAllEmployees();

}
