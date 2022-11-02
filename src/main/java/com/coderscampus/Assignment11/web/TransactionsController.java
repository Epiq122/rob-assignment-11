package com.coderscampus.Assignment11.web;


import com.coderscampus.Assignment11.domain.Transaction;
import com.coderscampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionsController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions")
    public String getTransactions(ModelMap model) {
        List<Transaction> transactions = transactionService.findAll();
        model.put("transactions", transactions);
        return "transactions";

    }

    @GetMapping("/transactions/{transactionId}")
    public String viewTransaction(ModelMap model, @PathVariable Long transactionId) {
        Transaction transaction = transactionService.findById(transactionId);
        model.put("transaction", transaction);

        return "transaction";
    }

}