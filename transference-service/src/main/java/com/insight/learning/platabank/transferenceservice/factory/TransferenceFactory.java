package com.insight.learning.platabank.transferenceservice.factory;

import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import com.insight.learning.platabank.transferenceservice.service.TransferenceService;
import com.insight.learning.platabank.transferenceservice.service.impl.DOCTransferenceServiceImpl;
import com.insight.learning.platabank.transferenceservice.service.impl.TEDTransferenceServiceImpl;
import com.insight.learning.platabank.transferenceservice.service.impl.TEVTransferenceServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class TransferenceFactory {

    private static TEVTransferenceServiceImpl tevTransference;
    private static TEDTransferenceServiceImpl tedTransference;
    private static DOCTransferenceServiceImpl docTransference;

    public TransferenceFactory(TEVTransferenceServiceImpl tevTransference, TEDTransferenceServiceImpl tedTransference, DOCTransferenceServiceImpl docTransference){
        this.tevTransference = tevTransference;
        this.docTransference = docTransference;
        this.tedTransference = tedTransference;
    }

    public static TransferenceService getTransference(TransferType transferType){
        if(transferType == null) return TransferenceFactory.tevTransference;

        switch(transferType){
            case TEV:
                return TransferenceFactory.tevTransference;
            case TED:
                return TransferenceFactory.tedTransference;
            case DOC :
                return TransferenceFactory.docTransference;
            default: throw new IllegalArgumentException("No type transference found");
        }
    }

}
