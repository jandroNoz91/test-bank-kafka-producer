package com.example.bankProducer.controller;

import com.example.bankProducer.config.ProducerConfig;
import com.example.bankProducer.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class TransactionController {

    @Autowired
    ProducerConfig producerConfig;

    //New transaction
    @PostMapping("/{account-number}/transaction")
    public void sendMessage(@PathVariable(name = "account-number") Long account,
                            @RequestBody Transaction transaction){
        transaction.setAccount(account);
        producerConfig.kafkaTemplate(producerConfig.providerFactory()).send("EVT_BANK_ACCOUNT_TRANSACTION", String.valueOf(transaction));
    }
}
