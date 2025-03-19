package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.exception.DuplicateUsernameException;
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

    // create new account
    public Account addAccount( Account account)  throws IllegalArgumentException, DuplicateUsernameException {
        if (accountRepository.findByUsername(account.getUsername()) != null) {
            throw new DuplicateUsernameException();
        }
        if (account.getUsername() != null && account.getUsername() != "" && account.getPassword().length() >= 4) {
            return accountRepository.save(account);
        } else {
            throw new IllegalArgumentException();
        }
    }

    // verify account exists
    public Account verifyAccount(Account account) {
        Account uniqueAccount = accountRepository.findByUsername(account.getUsername());
        if(uniqueAccount != null && uniqueAccount.getPassword().equals(account.getPassword())) {
            return uniqueAccount;
        }
        return null;
    }
}
