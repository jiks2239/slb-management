package com.slb.dtos;

import com.slb.enums.NativePlace;
import com.slb.enums.PayrollType;

import java.util.Date;

public class EmployeeDTO {

    private String id;
    private String name;
    private Date latestJoinedDate;
    private Date relieveDate;
    private PayrollType type;
    private NativePlace nativePlace;
    private Long currentWage;
    private Long offDays;
    private Long grossWage;
    private Long netWage;
    private Long currentDebitBalance;
    private Long totalDebitBalance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLatestJoinedDate() {
        return latestJoinedDate;
    }

    public void setLatestJoinedDate(Date latestJoinedDate) {
        this.latestJoinedDate = latestJoinedDate;
    }

    public Date getRelieveDate() {
        return relieveDate;
    }

    public void setRelieveDate(Date relieveDate) {
        this.relieveDate = relieveDate;
    }

    public PayrollType getType() {
        return type;
    }

    public void setType(PayrollType type) {
        this.type = type;
    }

    public NativePlace getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(NativePlace nativePlace) {
        this.nativePlace = nativePlace;
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

    public Long getGrossWage() {
        return grossWage;
    }

    public void setGrossWage(Long grossWage) {
        this.grossWage = grossWage;
    }

    public Long getNetWage() {
        return netWage;
    }

    public void setNetWage(Long netWage) {
        this.netWage = netWage;
    }

    public Long getCurrentDebitBalance() {
        return currentDebitBalance;
    }

    public void setCurrentDebitBalance(Long currentDebitBalance) {
        this.currentDebitBalance = currentDebitBalance;
    }

    public Long getTotalDebitBalance() {
        return totalDebitBalance;
    }

    public void setTotalDebitBalance(Long totalDebitBalance) {
        this.totalDebitBalance = totalDebitBalance;
    }
}
