package com.sqc.exception;

public class DrugNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7631719126632906188L;

	public DrugNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public DrugNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DrugNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DrugNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DrugNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
