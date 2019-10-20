package com.insight.learning.platabank.accountservice.model;

import com.insight.learning.platabank.accountservice.enumerator.AccountStatus;

import javax.persistence.Entity;

@Entity
public class SavingAccount extends Account{

    public SavingAccount() {
        super(AccountStatus.OPENED, false);
    }

    @Override
    public String initialStatusPolicy() {
        return "Saving Accounts are immediately opened.";
    }
}
