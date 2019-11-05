package com.insight.learning.platabank.transferenceservice.builders;

import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;

import java.time.LocalDateTime;

public class TransferenceBuilder {

    private Transference transference;

    private TransferenceBuilder(){

    }

    public static TransferenceBuilder oneTransference(){
        TransferenceBuilder transferenceBuilder = new TransferenceBuilder();
        transferenceBuilder.transference = new Transference();
        return transferenceBuilder;
    }

    public TransferenceBuilder ofType(TransferType transferType){
        this.transference.setTransferType(transferType);
        return this;
    }

    public TransferenceBuilder ammountValue(Double value){
        this.transference.setAmount(value);
        return this;
    }

    public TransferenceBuilder atDate(LocalDateTime now) {
        this.transference.setTransferDate(now);
        return this;
    }

    public TransferenceBuilder fromAccount(Account sourceAccount) {
        this.transference.setAccount(sourceAccount);
        return this;
    }

    public TransferenceBuilder toPayee(Payee payee) {
        this.transference.setPayee(payee);
        return this;
    }

    public Transference transference(){
        return this.transference;
    }
}
