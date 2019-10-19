package com.insight.learning.platabank.accountservice.model;

import com.insight.learning.platabank.accountservice.enumerator.AccountStatus;

import javax.persistence.Entity;

@Entity
public class CheckingAccount extends Account {

    public CheckingAccount() {
        super(AccountStatus.ANALYZE, true);
    }

    @Override
    public String initialStatusPolicy() {
        return "Checking Accounts needs analyze from financial department before be opened.";
    }
}
