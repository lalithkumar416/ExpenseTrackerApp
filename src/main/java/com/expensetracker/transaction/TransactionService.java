package com.expensetracker.transaction;

import com.expensetracker.transaction.data.TransactionEntity;
import com.expensetracker.transaction.data.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    TransactionRepository transactionRepository;

    public List<TransactionEntity> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public String submitTransaction(String name, String description, long amount, String currency,
                                    String user) {
        TransactionEntity transactionEntity = TransactionEntity.builder()
                .name(name)
                .description(description)
                .amount(amount)
                .currency(currency)
                .created_by(user)
                .build();
        saveAndGenerateId(transactionEntity);
        return transactionEntity.getTransactionId();
    }

    private TransactionEntity saveAndGenerateId(TransactionEntity transactionEntity) {
        String transactionId = "TRX" + String.format("%07d", transactionEntity.getId());
        transactionEntity.setTransactionId(transactionId);
        transactionRepository.saveAndFlush(transactionEntity);
        return transactionEntity;
    }
}
