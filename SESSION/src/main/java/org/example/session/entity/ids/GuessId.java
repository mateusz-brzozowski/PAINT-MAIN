package org.example.session.entity.ids;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class GuessId {

	Integer sessionId;
	Integer guessNumber;
}
