package edu.ing.accountmanager.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ing.accountmanager.dto.AccountDto;
import edu.ing.accountmanager.exception.AccountMngrBusinessException;
import edu.ing.accountmanager.exception.AccountMngrTehnicalException;
import edu.ing.accountmanager.service.AccountService;

@RestController
public class AccountController {

	private static final Logger LOGGER = LogManager.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	public ResponseEntity<List<AccountDto>> getAccounts() {

		List<AccountDto> accounts = accountService.getAccounts();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("GET /accounts Response: {}", accounts);
		}
		return ResponseEntity.ok(accounts);
	}

	@PostMapping("/accounts")
	public ResponseEntity<Long> saveAccount(@RequestBody AccountDto account) throws AccountMngrBusinessException, AccountMngrTehnicalException {
		return ResponseEntity.ok(accountService.save(account));
	}
}
