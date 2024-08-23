package com.learning.banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// Getter and Setter are lombok annotations
@NoArgsConstructor
@AllArgsConstructor
// these are constructor related annotations

@Table(name = "accounts")
// create table named as accounts with the below entities
@Entity
// using this annotation to make this class as a JPA Entity
public class Account {
    @Id //make id as primary key (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment PK
    private Long id;

    @Column(name = "account_holder_name") //create a col in the db table
    private String accountHolderName;
    private double balance;
}
