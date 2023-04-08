package org.example.session.exception;

public class UsersNotMatching extends RuntimeException {

	public UsersNotMatching() {
		super("User id doesn't match session's user id");
	}
}
