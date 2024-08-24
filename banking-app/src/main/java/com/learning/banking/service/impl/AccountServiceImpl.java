package com.learning.banking.service.impl;

// Account service implementation - class

import com.learning.banking.dto.AccountDto;
import com.learning.banking.entity.Account;
import com.learning.banking.mapper.AccountMapper;
import com.learning.banking.repository.AccountRepository;
import com.learning.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// to automatically create spring bean and inject the dependencies for this class
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired // this coule be ignored as it will be done automatically
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    // createAccount method will call accountRepository to save the account into a DB
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account); // returns the saved entity
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        // if account id exists in the database or not
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        // to deposit the amount, get existing balance and add the amount
        double total = account.getBalance() + amount;

        // setting the total balance using setters
        account.setBalance(total);

        // saving the current value
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        // if account id exists in the database or not
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        // if the balance is insufficient
        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }


        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
