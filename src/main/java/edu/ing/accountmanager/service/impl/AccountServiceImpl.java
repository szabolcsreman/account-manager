package edu.ing.accountmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ing.accountmanager.dto.AccountDto;
import edu.ing.accountmanager.model.Account;
import edu.ing.accountmanager.repository.AccountRepository;
import edu.ing.accountmanager.service.AccountService;

@Service("account-service")
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	private ModelMapper mapper = new ModelMapper();

	@Override
	public List<AccountDto> getAccounts() {
		List<AccountDto> accountDtos = new ArrayList<>();
		for(Account account : accountRepository.findAll()) {
			AccountDto accountDto = mapper.map(account, AccountDto.class);
			accountDtos.add(accountDto);
		}
		return accountDtos;
	}

}
