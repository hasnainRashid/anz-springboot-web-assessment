package com.anz.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account_transactions")
public class AccountTransactionsList implements Serializable {
    private static final long serialVersionUID = 5489169102778666134L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String accountName;
    private String valueDate;
    private String currency;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String debitOrCredit;
    private String transactionNarrative;
}
