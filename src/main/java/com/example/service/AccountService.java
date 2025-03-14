package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public class AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository AccountRepository){
        this.accountRepository = accountRepository;
    }

    //  && accountRepository.findByUsername(account.getUsername()) != null
    // create new account
    public Account addAccount( Account account) {
        if (account.getUsername() != null && account.getUsername() != ""
            && account.getPassword().length() >= 4) {
            return accountRepository.save(account);
            
        }
    return null;
    }

    // verify account exists
}
