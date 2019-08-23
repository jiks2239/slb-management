package com.slb.ServiceImpls;

import com.slb.daos.EmployeeRepository;
import com.slb.domains.Account;
import com.slb.domains.Employee;
import com.slb.services.EmployeeService;
import com.slb.utils.SlbUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Set<Employee> employees = new HashSet<>();

    @PostConstruct
    private void loadAllEmployees() {
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
    }

    @Override
    public Employee getEmployeeByName(String name) {
        if (ObjectUtils.isEmpty(name))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid Employee Name");
        Employee result = employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
        if (result == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found.");
        return result;
    }

    @Override
    public Employee getEmployeeById(String id) {
        if (StringUtils.isEmpty(id))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid Employee Id.");
        Employee employeeFound = employees.stream().filter(employee -> StringUtils.equals(employee.getId(), id)).findAny().orElse(null);
        if (employeeFound == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not Found with " + id);
        return employeeFound;
    }

    @Override
    public Set<Employee> getEmployeesByDept(String department) {
       if (StringUtils.isEmpty(department))
           throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid department.");
        Set<Employee> result = employees.stream().filter(employee -> employee.getDepartment().getValue().equals(department)).collect(Collectors.toSet());
        if (result.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employees not found.");
        return result;
    }

    @Override
    public Employee save(Employee employee) {
        if (ObjectUtils.isEmpty(employee))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid Employee.");
        return employeeRepository.save(employee);
    }

    @Override
    public Employee calculateGrossWage(Employee employee) {
        if (ObjectUtils.isEmpty(employee) || StringUtils.isEmpty(employee.getId()))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid Employee.");
        Employee result = getEmployeeById(employee.getId());
        SlbUtils.calculateGrossWage(result);
        return update(result);
    }

    @Override
    public Employee calculateNetWage(Employee employee) {
        if (ObjectUtils.isEmpty(employee) || StringUtils.isEmpty(employee.getId()))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid Employee.");
        Employee result = getEmployeeById(employee.getId());
        Account account = SlbUtils.calculateNetWage(result);
        result.setTotalDebitBalance(result.getTotalDebitBalance() + account.getCurrentDebitBalance());
        return update(result);
    }

    @Override
    public Employee updateTotalDebitBalance(Employee employee) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        if (ObjectUtils.isEmpty(employee))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid Employee");
        Employee result = employees.stream().filter(emp -> emp.getId().equals(employee.getId())).findFirst().orElse(null);
        if (result == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        return save(employee);
    }

    @Override
    public Boolean delete(String id) {
        if (StringUtils.isEmpty(id))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Invalid id");
        Employee result = employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
        if (result == null)
            return false;
        employeeRepository.delete(result);
        return true;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return employees;
    }
}
