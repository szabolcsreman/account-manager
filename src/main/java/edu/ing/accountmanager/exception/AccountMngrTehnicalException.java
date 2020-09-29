package edu.ing.accountmanager.exception;

public class AccountMngrTehnicalException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountMngrTehnicalException(String errorMsg) {
		super(errorMsg);
	}

	public AccountMngrTehnicalException(String errorMsg, Throwable ex) {
		super(errorMsg, ex);
	}

	public AccountMngrTehnicalException(Throwable ex) {
		super(ex);
	}
}
