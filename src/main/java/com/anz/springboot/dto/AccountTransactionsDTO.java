package com.anz.springboot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AccountTransactionsDTO {
    private String accountNumber;
    private String accountName;
    private String valueDate;
    private String currency;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String debitOrCredit;
    private String transactionNarrative;
}
