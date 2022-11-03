package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
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
        List<Transaction> txns = transactionRepo.findAll();
        txns.sort(Comparator.comparing(Transaction::getDate));
        return txns;
    }

    public Transaction findById(Long transactionId) {
        Optional<Transaction> idFound =
                transactionRepo.findAll().stream().filter(t -> t.getId().equals(transactionId)).findAny();
        return idFound.orElse(null);
    }


}
