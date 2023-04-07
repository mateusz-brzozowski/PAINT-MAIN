package org.example.session.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LetterResult {
	UNKNOWN("#818384"),
	LETTER_ABSENT("#3a3a3c"),
	CORRECT_LETTER_INCORRECT_PLACE("#b59f3b"),
	CORRECT_LETTER_CORRECT_PLACE("#538d4e"),
	;
	private final String color;
}
