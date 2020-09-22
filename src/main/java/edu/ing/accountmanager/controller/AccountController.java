package edu.ing.accountmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ing.accountmanager.dto.AccountDto;
import edu.ing.accountmanager.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts")
	public List<AccountDto> getAccounts() {
		return accountService.getAccounts();
	}
}
