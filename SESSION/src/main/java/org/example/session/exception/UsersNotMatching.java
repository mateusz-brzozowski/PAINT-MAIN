package org.example.session.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UsersNotMatching extends RuntimeException {

	public UsersNotMatching() {
		super("User id doesn't match session's user id");
	}
}
