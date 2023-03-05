package com.expensetracker.transaction.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_sequence")
    @SequenceGenerator(name = "transactions_sequence", sequenceName = "transactions_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private long amount;

    @Column(name="currency")
    private String currency;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Date created_at;

    @Column(name = "last_updated", insertable = false)
    private Date last_updated;

    @Column(name = "created_by")
    private String created_by;
}
