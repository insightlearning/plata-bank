package com.insight.learning.platabank.transferenceservice.service;

import com.insight.learning.platabank.transferenceservice.dto.TransferenceDTO;

public abstract class TransferenceService {

    public abstract TransferenceDTO doTransference(TransferenceDTO transferenceDTO);

}
