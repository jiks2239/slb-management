package com.slb.services;

import com.slb.domains.Employee;
import com.slb.dtos.DebitBalanceDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface EmployeeService {

    Employee getEmployeeByName(String name);

    Employee getEmployeeById(String id);

    Set<Employee> getEmployeesByDept(String department);

    Employee save(Employee employee);

    Employee calculateGrossWage(String employeeId);

    Employee calculateNetWage(String employeeId);

    Employee updateTotalDebitBalance(DebitBalanceDTO debitBalanceDTO);

    Employee update(Employee employee);

    Boolean delete(String id);

    Set<Employee> getAllEmployees();

}
