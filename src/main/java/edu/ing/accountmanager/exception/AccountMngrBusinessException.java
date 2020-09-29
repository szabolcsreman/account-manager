package edu.ing.accountmanager.exception;

public class AccountMngrBusinessException extends Exception {

	private static final long serialVersionUID = 3030775799638184994L;

	public AccountMngrBusinessException(String errorMsg) {
		super(errorMsg);
	}

	public AccountMngrBusinessException(String errorMsg, Throwable ex) {
		super(errorMsg, ex);
	}

	public AccountMngrBusinessException(Throwable ex) {
		super(ex);
	}
}
