package edu.ing.accountmanager.service;

import java.util.List;

import edu.ing.accountmanager.dto.AccountDto;
import edu.ing.accountmanager.exception.AccountMngrBusinessException;
import edu.ing.accountmanager.exception.AccountMngrTehnicalException;

public interface AccountService {
	
	public List<AccountDto> getAccounts();
	
	public Long save(AccountDto accountDto) throws AccountMngrBusinessException, AccountMngrTehnicalException;

}
