package com.slb.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slb.enums.TransactionType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "total_debit_record")
public class TotalDebitRecord extends AuditModel{

    private static final long serialVersionUID = 6387575517559465394L;

    private Long totalDebitBalance;

    @NotBlank(message = "Transaction Amount cannot be empty.")
    private Long transactionAmount;

    @NotBlank(message = "Transaction Date cannot be empty.")
    private Date transactionDate;

    @NotBlank(message = "Transaction Type cannot be empty.")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employee employee;

    public Long getTotalDebitBalance() {
        return totalDebitBalance;
    }

    public void setTotalDebitBalance(Long totalDebitBalance) {
        this.totalDebitBalance = totalDebitBalance;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
