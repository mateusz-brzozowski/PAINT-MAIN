package org.example.session.exception;

public class IncorrectWordLength extends RuntimeException {

	public IncorrectWordLength() {
		super("Provided guess has incorrect length");
	}
}
