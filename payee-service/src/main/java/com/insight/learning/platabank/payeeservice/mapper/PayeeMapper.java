package com.insight.learning.platabank.payeeservice.mapper;

import com.insight.learning.platabank.payeeservice.domain.Account;
import com.insight.learning.platabank.payeeservice.domain.Bank;
import com.insight.learning.platabank.payeeservice.domain.Payee;
import com.insight.learning.platabank.payeeservice.dto.AccountDTO;
import com.insight.learning.platabank.payeeservice.dto.BankDTO;
import com.insight.learning.platabank.payeeservice.dto.PayeeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PayeeMapper {
     PayeeDTO toPayeeDTO(Payee payee);

    Payee toPayee(PayeeDTO payeeDTO);

    AccountDTO toAccountDTO(Account account);

    Account toAccount(AccountDTO accountDTO);

    BankDTO toBankDTO(Bank bank);

    Bank toBank(BankDTO bankDTO);
}
