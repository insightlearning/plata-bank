package com.insight.learning.platabank.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Customer {
    @Id private Long id;
    private String fullName;
}
