package org.example.session.exception;

public class GuessLimitExceeded extends RuntimeException {

	public GuessLimitExceeded() {
		super("You have exceeded guess limit! You cannot guess any more");
	}
}
