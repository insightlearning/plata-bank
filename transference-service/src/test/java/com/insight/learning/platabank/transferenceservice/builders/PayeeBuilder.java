package com.insight.learning.platabank.transferenceservice.builders;

import java.text.DecimalFormat;

public class PayeeBuilder {

    private Payee payee;

    private PayeeBuilder(){}

    public static PayeeBuilder onePayee(){
        PayeeBuilder payeeBuilder = new PayeeBuilder();
        payeeBuilder.payee = new Payee();
        return payeeBuilder;
    }

    public PayeeBuilder yourName(String name){
        payee.setName(name);
        return this;
    }

    public PayeeBuilder account(Integer account){
        payee.setAccount(account);
        return this;
    }

    public PayeeBuilder withCpf(String cpf){
        payee.setCpf(cpf);
        return this;
    }

    public Payee payee(){
        return payee;
    }
}
