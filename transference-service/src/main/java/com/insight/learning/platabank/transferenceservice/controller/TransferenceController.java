package com.insight.learning.platabank.transferenceservice.controller;

import com.insight.learning.platabank.transferenceservice.builders.Transference;
import com.insight.learning.platabank.transferenceservice.dto.TransferenceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transference")
public class TransferenceController {

    @PostMapping
    public ResponseEntity<TransferenceDTO> doTransference(Transference docTransference) {
        return new ResponseEntity<TransferenceDTO>(new TransferenceDTO(), HttpStatus.OK);
    }
}
