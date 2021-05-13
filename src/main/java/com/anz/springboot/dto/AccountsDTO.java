package com.anz.springboot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AccountsDTO implements Serializable {
    private static final long serialVersionUID = 6950581866439108685L;

    private String accountNumber;
    private String accountName;
    private String accountType;
    private String balanceDate;
    private String currency;
    private BigDecimal openingAvlBal;
}
