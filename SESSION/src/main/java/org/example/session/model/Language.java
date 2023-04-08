package org.example.session.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Language {

	Integer id;
	String code;
	String name;
	String flagUrl;
}
