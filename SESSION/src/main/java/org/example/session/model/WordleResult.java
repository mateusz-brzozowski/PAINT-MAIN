package org.example.session.model;

import java.util.List;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class WordleResult {

	List<LetterResult> currentGuess;

	public boolean hasWon() {
		return currentGuess.stream()
				.allMatch(it -> it == LetterResult.CORRECT_LETTER_CORRECT_PLACE);
	}
}
