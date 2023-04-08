package org.example.session.mapper;

import org.example.session.config.MapstructConfig;
import org.example.session.entity.SessionEntity;
import org.example.session.model.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface SessionMapper {

	@Mapping(target = "id")
	@Mapping(target = "userId")
	@Mapping(target = "createdDate")
	@Mapping(target = "wordLength")
	@Mapping(target = "languageId")
	Session entityToDto(SessionEntity entity);
}
