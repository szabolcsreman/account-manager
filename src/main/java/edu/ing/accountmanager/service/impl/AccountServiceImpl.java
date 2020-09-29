package edu.ing.accountmanager.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ing.accountmanager.dto.AccountDto;
import edu.ing.accountmanager.exception.AccountMngrBusinessException;
import edu.ing.accountmanager.exception.AccountMngrTehnicalException;
import edu.ing.accountmanager.model.Account;
import edu.ing.accountmanager.model.AccountType;
import edu.ing.accountmanager.model.User;
import edu.ing.accountmanager.repository.AccountRepository;
import edu.ing.accountmanager.repository.UserRepository;
import edu.ing.accountmanager.service.AccountService;

@Service("account-service")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public List<AccountDto> getAccounts() {
		List<AccountDto> accountDtos = new ArrayList<>();
		for (Account account : accountRepository.findAll()) {
			AccountDto accountDto = mapper.map(account, AccountDto.class);
			accountDto.setUserId(account.getUser().getId());
			accountDtos.add(accountDto);
		}
		return accountDtos;
	}

	@Override
	public Long save(AccountDto accountDto) throws AccountMngrBusinessException, AccountMngrTehnicalException {
		Optional<User> user = userRepository.findById(accountDto.getUserId());
		if (user.isEmpty()) {
			throw new AccountMngrTehnicalException("Invalid user");
		}

		if (Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY).contains(accountDto.getOpeningDate().getDayOfWeek())
				|| accountDto.getOpeningDate()
						.isBefore(LocalDateTime.of(LocalDate.of(accountDto.getOpeningDate().getYear(),
								accountDto.getOpeningDate().getMonth(), accountDto.getOpeningDate().getDayOfMonth()),
								LocalTime.of(9, 0)))
				|| accountDto.getOpeningDate()
						.isAfter(LocalDateTime.of(LocalDate.of(accountDto.getOpeningDate().getYear(),
								accountDto.getOpeningDate().getMonth(), accountDto.getOpeningDate().getDayOfMonth()),
								LocalTime.of(17, 0)))) {
			throw new AccountMngrBusinessException("Unavailable timeframe");
		}

		Optional<Account> account = accountRepository.findSavingAccountByUser(user.get());
		if (AccountType.SAVING == accountDto.getType() && account.isPresent()) {
			throw new AccountMngrBusinessException("There already exists a SAVING account for current user");
		} else {
			Account savedAccount = accountRepository.save(mapper.map(accountDto, Account.class));
			return savedAccount.getId();
		}
	}

}
