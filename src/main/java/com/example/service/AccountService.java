package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository AccountRepository){
        this.accountRepository = accountRepository;
    }

    // 
    // create new account
    public Account addAccount( Account account) {
        if (account.getUsername() != null && account.getUsername() != "" && account.getPassword().length() >= 4 
        && accountRepository.findByUsername(account.getUsername()) != null) {
            return accountRepository.save(account);
        }
        return null;
    }

    // && accountRepository.findByPassword(account.getPassword()) != null
    // verify account exists
    public Account verifyAccount(Account account) {
        if(accountRepository.existsById(account.getAccountId())) {
            return account;
        }
        return null;
    }
}
