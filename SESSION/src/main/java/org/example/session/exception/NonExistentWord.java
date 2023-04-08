package org.example.session.exception;

public class NonExistentWord extends RuntimeException {

	public NonExistentWord() {
		super("Provided word does not exist");
	}
}
