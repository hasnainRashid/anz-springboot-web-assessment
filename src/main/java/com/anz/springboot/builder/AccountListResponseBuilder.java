package com.anz.springboot.builder;

import com.anz.springboot.dto.AccountTransactionsDTO;
import com.anz.springboot.dto.AccountsDTO;
import com.anz.springboot.entity.AccountTransactionsList;
import com.anz.springboot.entity.AccountsList;

public class AccountListResponseBuilder {
    public static AccountsDTO build(AccountsList accountsList){
        AccountsDTO accountsDTO = new AccountsDTO();
        accountsDTO.setAccountNumber(accountsList.getAccountNumber());
        accountsDTO.setCurrency(accountsList.getCurrency());
        accountsDTO.setAccountName(accountsList.getAccountName());
        accountsDTO.setAccountType(accountsList.getAccountType());
        accountsDTO.setBalanceDate(accountsList.getBalanceDate());
        accountsDTO.setOpeningAvlBal(accountsList.getOpeningAvlBal());

        return accountsDTO;
    }
}
