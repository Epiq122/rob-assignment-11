package com.coderscampus.Assignment11.service;

import com.coderscampus.Assignment11.domain.Transaction;
import com.coderscampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private Long transactionId = 0L;

    @Autowired
    private TransactionRepository transactionRepo;

    public Transaction findById(Long transactionId) {
        return transactionRepo.findById(transactionId);
    }

    public List<Transaction> findAll() {
        return transactionRepo.findAll();
    }
}
