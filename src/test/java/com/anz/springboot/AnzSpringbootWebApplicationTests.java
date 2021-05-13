package com.anz.springboot;

import com.anz.springboot.dto.PageRequestDTO;
import com.anz.springboot.entity.AccountTransactionsList;
import com.anz.springboot.entity.AccountsList;
import com.anz.springboot.repository.AccountTransactionRepository;
import com.anz.springboot.repository.AccountsRepository;
import com.anz.springboot.service.AccountListService;
import com.anz.springboot.util.PaginationUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnzSpringbootWebApplicationTests {

	@Autowired
	private AccountListService accountListService;

	@MockBean
	private AccountsRepository accountsRepository;

	@MockBean
	private AccountTransactionRepository accountTransactionRepository;

	@Test
	public void test_getAccountsListTest(){
		when(accountsRepository.findAllById("ABC1234"))
				.thenReturn(
						(Set<AccountsList>) Stream.of(
								new AccountsList(256l,"Acc789","AccName45",
										"AccType","balDate","AUD",
													BigDecimal.valueOf(35.78))).collect(Collectors.toSet()));
		assertEquals(1,accountListService.findUserAccounts("ABC1234").size());
	}

	@Test
	public void test_getAccountTransactionsTestsAgainstAccount(){
		Pageable pageable = PaginationUtil.getPageable(new PageRequestDTO(1,6,"sortby","dir"));
		when(accountTransactionRepository
				.findAccountTransactionsListByAccountNumber("ZXE123", pageable))
					.thenReturn((Page<AccountTransactionsList>) Stream.of(
							new AccountTransactionsList(654l,"acc789","accName","valDate","AUD", BigDecimal.valueOf(62.78),
									BigDecimal.valueOf(62.78),"debOrCred","tranNarr"))
							.collect(Collectors.toList()));

		assertEquals(1,
				accountListService.findUserAccountTransactions(
						new PageRequestDTO(1,6,"sortby","dir"),"ANZ456").getData().size());
	}
}
