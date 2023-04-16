package org.example.session.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectWordLength extends RuntimeException {

	public IncorrectWordLength() {
		super("Provided guess has incorrect length");
	}
}
