package com.insight.learning.platabank.transferenceservice.service.impl;

import com.insight.learning.platabank.transferenceservice.domain.Transference;
import com.insight.learning.platabank.transferenceservice.repository.TransferenceRepository;
import com.insight.learning.platabank.transferenceservice.service.TransferenceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TEVTransferenceServiceImpl extends TransferenceService {

    private TransferenceRepository repository;

    public TEVTransferenceServiceImpl(TransferenceRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<Transference> doTransference(Transference transference) {
        return Optional.ofNullable(repository.save(transference));
    }

}
