package com.anz.springboot.repository;

import com.anz.springboot.entity.AccountTransactionsList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransactionsList, Long> {
    Page<AccountTransactionsList> findAccountTransactionsListByAccountNumber(String accountNum, Pageable pageable);
}
