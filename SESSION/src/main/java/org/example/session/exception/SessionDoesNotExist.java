package org.example.session.exception;

public class SessionDoesNotExist extends RuntimeException {

	public SessionDoesNotExist() {
		super("Session with provided id doesn't exist");
	}
}
