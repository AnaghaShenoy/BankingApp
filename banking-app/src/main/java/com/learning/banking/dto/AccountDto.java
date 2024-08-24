package com.learning.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
// this annotation directly generates getters and setters methods
@AllArgsConstructor
// this provides constructors
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
//    @NotNull(message = "Account number cannot be null")
//    private Long accountNumber;
//
//    @NotEmpty(message = "Account holder name cannot be empty")
//    private String accountHolderName;
//
//    @Min(value = 0, message = "Balance must be positive")
//    private Double balance;

}
