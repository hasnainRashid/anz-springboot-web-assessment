package com.anz.springboot.service;

import com.anz.springboot.builder.PaginateResponse;
import com.anz.springboot.dto.AccountsDTO;
import com.anz.springboot.dto.PageRequestDTO;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.Set;

public interface AccountListService {
    Set<AccountsDTO> findUserAccounts(String userId);
    PaginateResponse findUserAccountTransactions(PageRequestDTO pageRequestDTO, String accountNum);
}
