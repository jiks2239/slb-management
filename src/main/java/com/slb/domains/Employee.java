package com.slb.domains;

import com.slb.enums.Department;
import com.slb.enums.NativePlace;
import com.slb.enums.PayrollType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "employee")
public class Employee extends AuditModel {

    private static final long serialVersionUID = -7607951853798021619L;

    @NotBlank(message = "Name cannot be empty")
    private String name;
    private Integer phoneNumber;

    @NotBlank(message = "Department cannot be empty")
    @Enumerated(EnumType.STRING)
    private Department department;

    @NotBlank(message = "Payroll Type cannot be empty")
    @Enumerated(EnumType.STRING)
    private PayrollType payrollType;

    /* Total Balance Debit amount*/
    private Long totalDebitBalance;

    @Enumerated(EnumType.STRING)
    private NativePlace place;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<TotalDebitRecord> totalDebitRecords = new HashSet<>();

    public Employee() {
        totalDebitBalance = 0L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public PayrollType getPayrollType() {
        return payrollType;
    }

    public void setPayrollType(PayrollType payrollType) {
        this.payrollType = payrollType;
    }

    public Long getTotalDebitBalance() {
        return totalDebitBalance;
    }

    public void setTotalDebitBalance(Long totalDebitBalance) {
        this.totalDebitBalance = totalDebitBalance;
    }

    public NativePlace getPlace() {
        return place;
    }

    public void setPlace(NativePlace place) {
        this.place = place;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<TotalDebitRecord> getTotalDebitRecords() {
        return totalDebitRecords;
    }

    public void setTotalDebitRecords(Set<TotalDebitRecord> totalDebitRecords) {
        this.totalDebitRecords = totalDebitRecords;
    }
}
