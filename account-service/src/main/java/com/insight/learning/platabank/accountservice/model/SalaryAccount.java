package com.insight.learning.platabank.accountservice.model;

import com.insight.learning.platabank.accountservice.enumerator.AccountStatus;

import javax.persistence.Entity;

@Entity
public class SalaryAccount extends Account{

    public SalaryAccount() {
        super(AccountStatus.FROZEN, false);
    }

    @Override
    public String initialStatusPolicy() {
        return "Salary Accounts are frozen until the first payment happens.";
    }
}
