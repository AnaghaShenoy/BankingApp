package com.learning.banking.controller;

import com.learning.banking.dto.AccountDto;
import com.learning.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// make this class as a spring MVC Rest controller
@RequestMapping("/api/accounts") // passing base URL for all rest APIs within this controller
public class AccountController {

    private AccountService accountService;

    //constructor based dependency injection
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add Account REST API
    // create method -> make that method REST API using annotations (to make a REST API)
    @PostMapping // POST method
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        // @RequestBody - maps request body to AccountDto object (java object)
        // @RequestBody contains json and it auto converts json to java
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
}
