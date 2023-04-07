package org.example.session.entity;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Value
@Table("LANGUAGES")
public class LanguageEntity {

	@Id
	@Column("LANGUAGE_ID")
	Integer id;

	String code;

	String name;

	@Column("FLAG_URL")
	String flagUrl;
}
