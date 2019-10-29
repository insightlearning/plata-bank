package com.insight.learning.platabank.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author padovese
 * @since 28/10/2019
 */

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Account not found.")
public class AccountNotFoundException extends RuntimeException{}
