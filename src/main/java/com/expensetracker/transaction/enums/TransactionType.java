package com.expensetracker.transaction.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TransactionType {

    EXPENSE("EXPENSE"),
    SAVINGS("SAVINGS"),
    INVESTMENT("INVESTMENT");

    String field;
}
