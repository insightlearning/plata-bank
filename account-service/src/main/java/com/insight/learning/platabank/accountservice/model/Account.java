package com.insight.learning.platabank.accountservice.model;

import com.insight.learning.platabank.accountservice.enumerator.AccountStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Random;

@Entity
@Data
@RequiredArgsConstructor
public  class Account {
    @Id private int number;
    private double balance;
    private AccountStatus status;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Customer customer;

    public Account(Customer customer){
        this.number = new Random().nextInt(899_999) + 100_000;
        this.balance = 0;
        this.status = AccountStatus.ACTIVATED;
        this.customer = customer;
    }

}
