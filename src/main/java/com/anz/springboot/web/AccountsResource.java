package com.anz.springboot.web;

import com.anz.springboot.builder.PaginateResponse;
import com.anz.springboot.dto.AccountsDTO;
import com.anz.springboot.dto.PageRequestDTO;
import com.anz.springboot.service.AccountListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class AccountsResource {
    private final AccountListService accountListService;

    @GetMapping("/accounts-list/{userId}")
    public ResponseEntity<Set<AccountsDTO>> getAccountsList(@PathVariable("userId") String userId){
        Set<AccountsDTO> userAccounts = accountListService.findUserAccounts(userId);
        return ResponseEntity.ok().body(userAccounts);
    }

    @GetMapping("/account-transactions/{accountNumber}")
    public ResponseEntity<PaginateResponse> getAccountTransactions(@RequestParam(value = "pages", defaultValue = "0") Integer page,
                                                                   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                                                   @RequestParam(value = "sortBy", required = false) String sortBy,
                                                                   @RequestParam(value = "direction", required = false) String direction,
                                                                   @RequestParam(value = "accountNum", required = true) String accountNum){

        return ResponseEntity.ok(accountListService
                .findUserAccountTransactions(new PageRequestDTO(page,limit,sortBy,direction), accountNum));
    }
}
