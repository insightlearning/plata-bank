package com.insight.learning.platabank.transferenceservice.controller;

import com.insight.learning.platabank.transferenceservice.dto.TransferenceDTO;
import com.insight.learning.platabank.transferenceservice.factory.TransferenceFactory;
import com.insight.learning.platabank.transferenceservice.service.TransferenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transference")
public class TransferenceController {

    private TransferenceFactory transferenceFactory;

    public TransferenceController(TransferenceFactory transferenceFactory){
        this.transferenceFactory = transferenceFactory;
    }

    @PostMapping
    public ResponseEntity<TransferenceDTO> doTransference(TransferenceDTO transferenceDTO) {

        TransferenceService transferenceService = transferenceFactory.getTransference(transferenceDTO.getTransferType());
        transferenceService.doTransference(transferenceDTO);

        return new ResponseEntity<TransferenceDTO>(new TransferenceDTO(), HttpStatus.OK);
    }
}
