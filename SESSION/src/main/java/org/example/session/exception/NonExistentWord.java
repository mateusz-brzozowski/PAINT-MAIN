package org.example.session.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NonExistentWord extends RuntimeException {

	public NonExistentWord() {
		super("Provided word does not exist");
	}
}
