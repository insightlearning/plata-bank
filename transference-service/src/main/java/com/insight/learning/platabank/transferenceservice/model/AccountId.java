package com.insight.learning.platabank.transferenceservice.model;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
class AccountId {

    private Integer agency;
    private Integer account;
    private Integer dac;

}
