package com.learning.banking.mapper;

import com.learning.banking.dto.AccountDto;
import com.learning.banking.entity.Account;

// to map Dto to entity and viceversa to use in service classes
public class AccountMapper {

    // to convert accountDto into JPA entity
    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
        return account;
    }

    // to convert account JPA entity to accountDto
    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
        return accountDto;
    }
}
