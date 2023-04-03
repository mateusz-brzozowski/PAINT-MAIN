package org.example.session.entity;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("WORDS")
public class WordEntity {

	@Id
	@Column("ID")
	Integer id;

	@Column("WORD")
	String word;
}
