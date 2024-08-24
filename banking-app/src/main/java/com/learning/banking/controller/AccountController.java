package com.learning.banking.controller;

import com.learning.banking.dto.AccountDto;
import com.learning.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    // Get Account REST API
    // method returns the account obj and ok method internally returns the HTTP status 200 OK
    @GetMapping("/{id}") // to handle HTTP GET requests | maps the incoming HTTP GET request to this method
    // the {id} in the annotation is the template variable
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        // @PathVariable is used to bind template path variable to argument
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // Deposit REST API
    @PutMapping("/{id}/deposit") // map incoming HTTP PUT requests
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request) {
        // @PathVariable - bind value of template URI variable({id}) to method argument(Long id)
        // @RequestBody - maps the request json body to Map java object
        // map is created with amount in a request body
        Double amount = request.get("amount"); // as it fetches data from deposit method
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw REST API
    //same as deposit
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    // Get All Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        // fetch all the accounts (List type) using getAllAccounts method
        List<AccountDto> accounts = accountService.getAllAccounts();
        // returning the list of accounts (List type)
        return ResponseEntity.ok(accounts);
    }

    // Delete Account REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }

    // ChatGPT's code
//    @PostMapping("/accounts")
//    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountDto accountDto) {
//        AccountDto createdAccount = accountService.createAccount(accountDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
//    }
}
