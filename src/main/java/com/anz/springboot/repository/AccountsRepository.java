package com.anz.springboot.repository;

import com.anz.springboot.entity.AccountsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsList, Long> {
    Set<AccountsList> findAllById(String userId);
}
