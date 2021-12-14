package com.n11.secondhomeworkbahadirseven.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.n11.secondhomeworkbahadirseven.exception.NoEntityFoundException;
import com.n11.secondhomeworkbahadirseven.exception.UserNotFoundException;

@ControllerAdvice
public class BootcampControllerAdvice {
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> handleException(UserNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = NoEntityFoundException.class)
	public ResponseEntity<String> handleException(NoEntityFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

	}
}
