package com.insight.learning.platabank.transferenceservice.controller;

import com.insight.learning.platabank.transferenceservice.domain.Transference;
import com.insight.learning.platabank.transferenceservice.dto.TransferenceDTO;
import com.insight.learning.platabank.transferenceservice.factory.TransferenceFactory;
import com.insight.learning.platabank.transferenceservice.mapper.TransferenceMapper;
import com.insight.learning.platabank.transferenceservice.service.TransferenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/transference")
public class TransferenceController {

    private TransferenceFactory transferenceFactory;

    private final TransferenceMapper transferenceMapper;

    public TransferenceController(TransferenceFactory transferenceFactory, TransferenceMapper transferenceMapper){
        this.transferenceFactory = transferenceFactory;
        this.transferenceMapper  = transferenceMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public TransferenceDTO doTransference(@RequestBody TransferenceDTO transferenceDTO) {

        TransferenceService transferenceService = transferenceFactory.getTransference(transferenceDTO.getTransferType());
        Optional<Transference> transference = transferenceService
                .doTransference(
                        transferenceMapper.toTransference(transferenceDTO)
                );

        return transferenceMapper.toTransferenceDTO(transference.get());
    }
}
