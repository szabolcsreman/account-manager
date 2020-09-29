package edu.ing.accountmanager.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import edu.ing.accountmanager.model.AccountType;

public class AccountDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private BigDecimal balance;
	
	private AccountType type;
	
	private LocalDateTime openingDate;
	
	private Long userId;

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

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AccountDto [id=" + id + ", balance=" + balance + ", type=" + type + ", openingDate=" + openingDate
				+ ", userId=" + userId + "]";
	}

}
