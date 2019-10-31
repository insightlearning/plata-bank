package com.insight.learning.platabank.transferenceservice.builders;

import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import com.insight.learning.platabank.transferenceservice.builders.Account;
import com.insight.learning.platabank.transferenceservice.builders.Payee;
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
        transference.setTransferType(transferType);
        return this;
    }

    public TransferenceBuilder ammountValue(Double value){
        transference.setAmount(value);
        return this;
    }

    public TransferenceBuilder atDate(LocalDateTime now) {
        transference.setTransferDate(now);
        return this;
    }

    public TransferenceBuilder fromAccount(Account sourceAccount) {
        transference.setAccount(sourceAccount);
        return this;
    }

    public TransferenceBuilder toPayee(Payee payee) {
        transference.setPayee(payee);
        return this;
    }

    public Transference transference(){
        return transference;
    }
}
