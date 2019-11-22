package com.insight.learning.platabank.transferenceservice.service.impl;

import com.insight.learning.platabank.transferenceservice.domain.Transference;
import com.insight.learning.platabank.transferenceservice.service.TransferenceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TEDTransferenceServiceImpl extends TransferenceService {

    @Override
    public Optional<Transference> doTransference(Transference transference) {
        return Optional.empty();
    }

}
