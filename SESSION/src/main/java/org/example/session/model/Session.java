package org.example.session.model;

import java.time.Instant;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Session {

	Integer id;
	Integer userId;
	Instant createdDate;

	Integer languageId;
	Integer wordLength;
}
