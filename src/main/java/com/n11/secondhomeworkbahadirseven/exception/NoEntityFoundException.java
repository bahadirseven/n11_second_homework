package com.n11.secondhomeworkbahadirseven.exception;

public class NoEntityFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoEntityFoundException(String errorMessage) {
		super(errorMessage);
	}
}
