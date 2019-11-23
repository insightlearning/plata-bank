package com.insight.learning.platabank.payeeservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PayeeDTO {

    private Long id;
    private List<AccountDTO> account;
    private String fullName;
    private String nickName;
    private String email;
}
