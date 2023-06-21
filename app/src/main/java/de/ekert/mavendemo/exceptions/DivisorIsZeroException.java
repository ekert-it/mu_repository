package de.ekert.mavendemo.exceptions;

public class DivisorIsZeroException extends Exception {

	/**
	 * DivisorIsZeroException is Serializable
	 */
	private static final long serialVersionUID = 8709720198127904892L;

	public DivisorIsZeroException(String message) {
		super(message);
	}

	public DivisorIsZeroException(Throwable cause) {
		super(cause);
	}

	public DivisorIsZeroException(String message, Throwable cause) {
		super(message, cause);
	}

	public DivisorIsZeroException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
