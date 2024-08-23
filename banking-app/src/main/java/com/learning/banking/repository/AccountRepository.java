package com.learning.banking.repository;

import com.learning.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // extending JpaRepository interface and is generic with 2 params - entity name & type of PK
    // AccountRepository interface will get CRUD db methods to perform operations

}
