package org.example.session.service;

import org.example.session.model.Language;
import reactor.core.publisher.Flux;

public interface LanguageService {

	Flux<Language> getAllLanguages();
}
