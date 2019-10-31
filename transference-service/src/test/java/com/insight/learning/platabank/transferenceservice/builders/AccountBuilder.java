package com.insight.learning.platabank.transferenceservice.builders;

public class AccountBuilder {

    private Account account;

    public AccountBuilder(){}

    public static AccountBuilder oneAccount(){
        AccountBuilder accountBuilder = new AccountBuilder();
        accountBuilder.account = new Account();
        return accountBuilder;
    }

    public AccountBuilder withAgency(Integer agency){
        account.setAgency(agency);
        return this;
    }

    public AccountBuilder withDac(Integer dac){
        account.setDac(dac);
        return this;
    }

    public AccountBuilder typeAccount(String typeAccount){
        account.setType(typeAccount);
        return this;
    }

    public AccountBuilder withAccount(Integer accountValue){
        account.setAccount(accountValue);
        return this;
    }

    public static Account account(){
        return account();
    }
}
