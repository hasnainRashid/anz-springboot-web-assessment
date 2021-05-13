package com.anz.springboot.service.impl;

import com.anz.springboot.builder.AccountListResponseBuilder;
import com.anz.springboot.builder.AccountTransactionsResponseBuilder;
import com.anz.springboot.builder.Paginate;
import com.anz.springboot.builder.PaginateResponse;
import com.anz.springboot.dto.AccountTransactionsDTO;
import com.anz.springboot.dto.AccountsDTO;
import com.anz.springboot.dto.PageRequestDTO;
import com.anz.springboot.entity.AccountTransactionsList;
import com.anz.springboot.entity.AccountsList;
import com.anz.springboot.repository.AccountTransactionRepository;
import com.anz.springboot.repository.AccountsRepository;
import com.anz.springboot.service.AccountListService;
import com.anz.springboot.util.PaginationUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountListServiceImpl implements AccountListService {
    private final AccountsRepository accountsRepository;
    private final AccountTransactionRepository accountTransactionRepository;

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public Set<AccountsDTO> findUserAccounts(String userId) {
        Set<AccountsList> userAccountsList = accountsRepository.findAllById(userId);
        //set dto from entity to return back
        //ExtendedSpringBeanUtils.copyProperties can also be used
        //using builder to gain more control over DTOs
        Set<AccountsDTO> accountsDTOSet = userAccountsList.stream()
                .map(AccountListResponseBuilder::build).collect(Collectors.toSet());

        return accountsDTOSet;
    }

    /**
     *
     * @param pageRequestDTO
     * @param accountNum
     * @return
     */
    @Override
    public PaginateResponse findUserAccountTransactions(PageRequestDTO pageRequestDTO, String accountNum) {
        Pageable pageable = PaginationUtil.getPageable(pageRequestDTO);

        Page<AccountTransactionsList> accountTransactionsListByAccountNumber
                = accountTransactionRepository.findAccountTransactionsListByAccountNumber(accountNum, pageable);
        List<AccountTransactionsDTO> transactionsDTOList = accountTransactionsListByAccountNumber.stream()
                .map(AccountTransactionsResponseBuilder::build).collect(Collectors.toList());

        return PaginateResponse.builder()
                .metaData(getMetadata(pageRequestDTO, accountTransactionsListByAccountNumber))
                .data(transactionsDTOList)
                .build();
    }

    /**
     *
     * @param requestDTO
     * @param page
     * @return
     */
    protected Paginate getMetadata(PageRequestDTO requestDTO, Page<?> page) {
        return Paginate.builder()
                .totalPages(page.getTotalPages())
                .totalElements((int) page.getTotalElements())
                .page(requestDTO.getPage())
                .size(page.getContent().size())
                .build();
    }

}
