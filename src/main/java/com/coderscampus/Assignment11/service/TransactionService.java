package com.coderscampus.Assignment11.service;

import com.coderscampus.Assignment11.domain.Transaction;
import com.coderscampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {


    @Autowired
    private TransactionRepository transactionRepo;


    public List<Transaction> findAll() {
        List<Transaction> transactions = transactionRepo.findAll();
        transactions.sort(Comparator.comparing(Transaction::getDate));
        return transactions;
    }

    public Transaction findById(Long transactionId) {
        Optional<Transaction> idFound =
                transactionRepo.findAll().stream().filter(t -> t.getId().equals(transactionId)).findAny();
        return idFound.orElse(null);
    }


}
