package com.insight.learning.platabank.payeeservice.controller;

import com.insight.learning.platabank.payeeservice.domain.Payee;
import com.insight.learning.platabank.payeeservice.dto.PayeeDTO;
import com.insight.learning.platabank.payeeservice.mapper.PayeeMapper;
import com.insight.learning.platabank.payeeservice.service.PayeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payee")
public class PayeeController {

    private final PayeeService payeeService;

    private final PayeeMapper payeeMapper;


    public PayeeController(PayeeService payeeService, PayeeMapper payeeMapper) {
        this.payeeService = payeeService;
        this.payeeMapper = payeeMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PayeeDTO create(@RequestBody PayeeDTO payeeDTO){
        Payee payee = payeeService.save(payeeMapper.toPayee(payeeDTO)).get();
        return payeeMapper.toPayeeDTO(payee);
    }

    @GetMapping("{id}")
    public PayeeDTO getPayeeById(@PathVariable Long id){
        Payee payee = payeeService.findById(id);
        return payeeMapper.toPayeeDTO(payee);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePayeeById(@PathVariable Long id){
        payeeService.deleteById(id);
    }

}
