package org.example.session.mapper;

import org.example.session.config.MapstructConfig;
import org.example.session.entity.LanguageEntity;
import org.example.session.model.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface LanguageMapper {

	@Mapping(target = "id")
	@Mapping(target = "code")
	@Mapping(target = "name")
	@Mapping(target = "flagUrl")
	Language entityToDto(LanguageEntity entity);
}
