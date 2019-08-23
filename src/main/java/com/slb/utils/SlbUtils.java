package com.slb.utils;

import com.slb.domains.Account;
import com.slb.domains.CurrentDebitRecord;
import com.slb.domains.Employee;


import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;


public class SlbUtils {


    public static Date getClosestJoinedDate(Set<Date> dates) {
        long now = System.currentTimeMillis();
        return Collections.min(dates, (d1, d2) -> {
            long diff1 = Math.abs(d1.getTime() - now);
            long diff2 = Math.abs(d2.getTime() - now);
            return Long.compare(diff1, diff2);
        });
    }

    public static Account getAccountByJoinedDate(Date date, Employee employee) {
        return employee.getAccounts().stream()
                .filter(account -> account.getJoinedDate().equals(date))
                .findFirst().orElse(null);
    }

    private static Account getLatestAccount(Employee employee) {
        Date closestDate = getClosestJoinedDate(employee.getAccounts()
                .stream().map(Account::getJoinedDate).collect(Collectors.toSet()));
        return getAccountByJoinedDate(closestDate, employee);
    }

    private static Account getLatestGrossWage(Account account) {
        LocalDate fromDate = LocalDate.parse(account.getJoinedDate().toString());
        LocalDate toDate = LocalDate.parse(new Date().toString());
        long workingDays = DAYS.between(fromDate, toDate) + 1;
        Long grossWage = workingDays * account.getCurrentWage();
        account.setGrossWages(grossWage);
        return account;
    }

    private static Account getLatestNetWage(Account account) {
        getLatestGrossWage(account);
        Set<CurrentDebitRecord> currentDebitRecords = account.getCurrentDebitRecords();
        if (currentDebitRecords.isEmpty())
            return account;
        Long totalDebit = currentDebitRecords.stream().mapToLong(CurrentDebitRecord::getCollectedAmount).sum();
        if (totalDebit > account.getGrossWages()) {
            account.setCurrentDebitBalance(totalDebit);
        }
        account.setNetWages(account.getGrossWages() - totalDebit);
        return account;
    }

    public static Account calculateGrossWage(Employee employee) {
        return getLatestGrossWage(getLatestAccount(employee));
    }

    public static Account calculateNetWage(Employee employee) {
        return getLatestNetWage(getLatestAccount(employee));
    }
}
