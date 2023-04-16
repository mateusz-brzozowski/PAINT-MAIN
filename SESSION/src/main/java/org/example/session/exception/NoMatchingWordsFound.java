package org.example.session.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoMatchingWordsFound extends RuntimeException {

	public NoMatchingWordsFound() {
		super("There are no words with such language / length combination");
	}
}
