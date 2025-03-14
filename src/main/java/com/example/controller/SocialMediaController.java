package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Account;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageService messageService;

    // create new account
    @PostMapping("/register/")
    public ResponseEntity<Account> postAccount(@RequestBody Account requestBody) {
        Account newAccount = accountService.addAccount(requestBody);
        return ResponseEntity.ok(newAccount);
    }

    // verify account exists
    @PostMapping("/login")
    public ResponseEntity<Account> postLogin(@RequestBody Account requestBody) {

    }

    // create new message
    @PostMapping("/messages")

    // get all messages
    @GetMapping("/messages")

    // get message given message id
    @GetMapping("/messages/{message_id}")

    // delete message given message id
    @DeleteMapping("messages/{message_id}")

    // update message given message id
    @PatchMapping("messages/{message_id}")

    // get all messages given account id
    @GetMapping("/accounts/{account_id}/messages")
}
