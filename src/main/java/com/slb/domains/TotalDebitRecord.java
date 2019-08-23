package com.slb.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "total_debit_record")
public class TotalDebitRecord extends AuditModel{

    private static final long serialVersionUID = 6387575517559465394L;

    private Long totalDebitRecord;

    @NotBlank(message = "Transaction Amount cannot be empty.")
    private Long transactionAmount;

    @NotBlank(message = "Transaction Date cannot be empty.")
    private Date transactionDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employee employee;

    public Long getTotalDebitRecord() {
        return totalDebitRecord;
    }

    public void setTotalDebitRecord(Long totalDebitRecord) {
        this.totalDebitRecord = totalDebitRecord;
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
}
