package com.slb.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Entity(name = "current_debit_record")
public class CurrentDebitRecord extends AuditModel {
    private static final long serialVersionUID = -6483565881193141159L;

    private Date collectedDate;
    private Long collectedAmount;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Account account;

    public Date getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(Date collectedDate) {
        this.collectedDate = collectedDate;
    }

    public Long getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(Long collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public Account getAccount() {
        return account;
    }

    public void setEmployee(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentDebitRecord currentDebitRecord = (CurrentDebitRecord) o;
        return Objects.equals(collectedDate, currentDebitRecord.collectedDate) &&
                Objects.equals(collectedAmount, currentDebitRecord.collectedAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectedDate, collectedAmount);
    }
}
