package org.example.session.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.session.mapper.LanguageMapper;
import org.example.session.model.Language;
import org.example.session.repository.LanguageRepository;
import org.example.session.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LanguageServiceImpl implements LanguageService {

	private final LanguageRepository repository;
	private final LanguageMapper mapper;

	@Override
	public Flux<Language> getAllLanguages() {
		return repository.findAll()
				.map(mapper::entityToDto);
	}
}
