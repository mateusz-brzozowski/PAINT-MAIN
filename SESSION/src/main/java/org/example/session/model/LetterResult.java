package org.example.session.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LetterResult {
	UNKNOWN,
	LETTER_ABSENT,
	CORRECT_LETTER_INCORRECT_PLACE,
	CORRECT_LETTER_CORRECT_PLACE,
	;
}
