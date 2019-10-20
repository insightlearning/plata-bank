package com.insight.learning.platabank.accountservice.model;

import com.insight.learning.platabank.accountservice.enumerator.AccountStatus;
import com.insight.learning.platabank.accountservice.enumerator.AccountType;
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
    private String type;

    public Account(AccountStatus status, boolean ableToDoPayments){
        this.number = new Random().nextInt(899_999) + 100_000;
        this.balance = 0;
        this.status = status;
        this.ableToDoPayments = ableToDoPayments;
    }

    public abstract String initialStatusPolicy();

    public String getType(){
        if(this instanceof CheckingAccount){
            return AccountType.CHECKING.toString();
        } else if (this instanceof SavingAccount){
            return AccountType.SAVING.toString();
        } else{
            return AccountType.SALARY.toString();
        }
    }

}
