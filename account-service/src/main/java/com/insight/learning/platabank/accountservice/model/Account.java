package com.insight.learning.platabank.accountservice.model;

import com.insight.learning.platabank.accountservice.enumerator.AccountStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

@Entity
@Data
public abstract class Account {
    @Id
    private int number;
    private double balance;
    private AccountStatus status;
    private boolean ableToDoPayments;

    public Account(AccountStatus status, boolean ableToDoPayments){
        this.number = new Random().nextInt(899_999) + 100_000;
        this.balance = 0;
        this.status = status;
        this.ableToDoPayments = ableToDoPayments;
    }

    public abstract String initialStatusPolicy();

}
