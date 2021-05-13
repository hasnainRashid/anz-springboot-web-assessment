package com.anz.springboot.builder;

import com.anz.springboot.dto.AccountTransactionsDTO;
import com.anz.springboot.entity.AccountTransactionsList;

public class AccountTransactionsResponseBuilder {
    public static AccountTransactionsDTO build(AccountTransactionsList accountTransactionsList){
        AccountTransactionsDTO accountTransactionsDTO = new AccountTransactionsDTO();
        accountTransactionsDTO.setAccountName(accountTransactionsList.getAccountName());
        accountTransactionsDTO.setAccountNumber(accountTransactionsList.getAccountNumber());
        accountTransactionsDTO.setTransactionNarrative(accountTransactionsList.getTransactionNarrative());
        accountTransactionsDTO.setCurrency(accountTransactionsList.getCurrency());
        accountTransactionsDTO.setDebitAmount(accountTransactionsList.getDebitAmount());
        accountTransactionsDTO.setDebitOrCredit(accountTransactionsList.getDebitOrCredit());
        accountTransactionsDTO.setValueDate(accountTransactionsList.getValueDate());
        accountTransactionsDTO.setCreditAmount(accountTransactionsList.getCreditAmount());

        return accountTransactionsDTO;
    }
}
