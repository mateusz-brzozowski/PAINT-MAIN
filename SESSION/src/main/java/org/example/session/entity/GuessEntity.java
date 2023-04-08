package org.example.session.entity;

import java.time.Instant;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("GUESSES")
public class GuessEntity {

	@Id
	@Column("GUESS_ID")
	Long id;

	@Column("SESSION_ID")
	Long sessionId;

	@Column("GUESS_NUMBER")
	Integer guessNumber;

	String guess;

	@Column("CREATED_DATE")
	Instant createdDate;
}
