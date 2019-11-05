package com.insight.learning.platabank.transferenceservice.factory;

import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import com.insight.learning.platabank.transferenceservice.service.TransferenceService;
import com.insight.learning.platabank.transferenceservice.service.impl.DOCTransferenceServiceImpl;
import com.insight.learning.platabank.transferenceservice.service.impl.TEDTransferenceServiceImpl;
import com.insight.learning.platabank.transferenceservice.service.impl.TEVTransferenceServiceImpl;

public class TransferenceFactory {

    public static TransferenceService getTransference(TransferType transferType){
        switch(transferType){
            case TEV:
                return new TEVTransferenceServiceImpl();
            case TED:
                return new TEDTransferenceServiceImpl();
            case DOC :
                return new DOCTransferenceServiceImpl();
        };
        return new DOCTransferenceServiceImpl();
    }

}
