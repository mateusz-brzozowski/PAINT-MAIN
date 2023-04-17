package org.example.session.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class GuessLimitExceeded extends RuntimeException {

	public GuessLimitExceeded() {
		super("You have exceeded guess limit! You cannot guess any more");
	}
}
