package com.slb.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "employee_account")
public class Account extends AuditModel {

    private static final long serialVersionUID = 773805340170354412L;

    /* Work joined date of current period */
    @NotBlank(message = "Joined Date cannot be empty")
    private Date joinedDate;

    /* Relieving date after work period */
    private Date relieveDate;

    @NotBlank(message = "Wage must not be empty")
    private Long currentWage;

    /* Total off Days */
    private Long offDays;

    /* Total Salary till date */
    private Long grossWages;

    /* Net salary after deductions */
    private Long netWages;

    /* Current Debit Balance*/
    private Long currentDebitBalance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employee employee;

    /*Amount collected during working period*/
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<CurrentDebitRecord> currentDebitRecords = new HashSet<>();

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Date getRelieveDate() {
        return relieveDate;
    }

    public void setRelieveDate(Date relieveDate) {
        this.relieveDate = relieveDate;
    }

    public Long getCurrentWage() {
        return currentWage;
    }

    public void setCurrentWage(Long currentWage) {
        this.currentWage = currentWage;
    }

    public Long getOffDays() {
        return offDays;
    }

    public void setOffDays(Long offDays) {
        this.offDays = offDays;
    }

    public Long getGrossWages() {
        return grossWages;
    }

    public void setGrossWages(Long grossWages) {
        this.grossWages = grossWages;
    }

    public Long getNetWages() {
        return netWages;
    }

    public void setNetWages(Long netWages) {
        this.netWages = netWages;
    }

    public Long getCurrentDebitBalance() {
        return currentDebitBalance;
    }

    public void setCurrentDebitBalance(Long currentDebitBalance) {
        this.currentDebitBalance = currentDebitBalance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<CurrentDebitRecord> getCurrentDebitRecords() {
        return currentDebitRecords;
    }

    public void setCurrentDebitRecords(Set<CurrentDebitRecord> currentDebitRecords) {
        this.currentDebitRecords = currentDebitRecords;
    }
}
