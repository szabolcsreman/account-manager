package edu.ing.accountmanager.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import edu.ing.accountmanager.model.AccountType;

public class AccountDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private BigDecimal balance;
	
	private AccountType type;
	
	private LocalDate openingDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	
}
