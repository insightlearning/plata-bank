package com.insight.learning.platabank.transferenceservice.factory;

import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import com.insight.learning.platabank.transferenceservice.service.TransferenceService;
import com.insight.learning.platabank.transferenceservice.service.impl.DOCTransferenceServiceImpl;
import com.insight.learning.platabank.transferenceservice.service.impl.TEDTransferenceServiceImpl;
import com.insight.learning.platabank.transferenceservice.service.impl.TEVTransferenceServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class TransferenceFactory {

    private TEVTransferenceServiceImpl tevTransference;
    private TEDTransferenceServiceImpl tedTransference;
    private DOCTransferenceServiceImpl docTransference;

    public TransferenceFactory(TEVTransferenceServiceImpl tevTransference, TEDTransferenceServiceImpl tedTransference, DOCTransferenceServiceImpl docTransference){
        this.tevTransference = tevTransference;
        this.docTransference = docTransference;
        this.tedTransference = tedTransference;
    }

    public TransferenceService getTransference(TransferType transferType){
        if(transferType == null) return docTransference;

        switch(transferType){
            case TEV:
                return tevTransference;
            case TED:
                return tedTransference;
            case DOC :
                return docTransference;
            default: throw new IllegalArgumentException("No type transference found");
        }
    }

}
