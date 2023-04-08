package org.example.session.exception;

public class WordContainsNonAlphaCharacters extends RuntimeException {

	public WordContainsNonAlphaCharacters() {
		super("Provided word contains non-alpha characters");
	}
}
