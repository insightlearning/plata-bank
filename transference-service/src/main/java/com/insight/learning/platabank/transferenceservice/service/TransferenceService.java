package com.insight.learning.platabank.transferenceservice.service;

import com.insight.learning.platabank.transferenceservice.dto.TransferenceDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransferenceService {

    public TransferenceDTO doTransference(TransferenceDTO transferenceDTO);

}
