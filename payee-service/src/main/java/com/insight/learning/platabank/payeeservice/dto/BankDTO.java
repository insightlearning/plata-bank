package com.insight.learning.platabank.payeeservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BankDTO {

    private long id;
    private Integer ISPB;
    private Integer code;
    private String name;
    private String nickName;
}
