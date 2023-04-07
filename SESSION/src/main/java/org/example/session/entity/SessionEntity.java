package org.example.session.entity;

import java.time.Instant;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("SESSIONS")
public class SessionEntity {

	@Id
	@Column("SESSION_ID")
	Integer id;

	@Column("USER_ID")
	Integer userId;

	@Column("WORD_ID")
	Integer wordId;

	Integer wordLength;

	// TODO: add multiple different modes

	@CreatedDate
	@Column("CREATED_DATE")
	Instant createdDate;
}
