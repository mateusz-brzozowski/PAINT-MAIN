package org.example.session.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SessionDoesNotExist extends RuntimeException {

	public SessionDoesNotExist() {
		super("Session with provided id doesn't exist");
	}
}
