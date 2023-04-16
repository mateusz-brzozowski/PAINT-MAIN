package org.example.session.exception;

public class NoMatchingWordsFound extends RuntimeException {

	public NoMatchingWordsFound() {
		super("There are no words with such language / length combination");
	}
}
