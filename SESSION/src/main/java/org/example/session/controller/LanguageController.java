package org.example.session.controller;

import lombok.RequiredArgsConstructor;
import org.example.session.model.Language;
import org.example.session.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("language")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LanguageController {

	private final LanguageService service;

	@GetMapping
	public Flux<Language> getAvailableLanguages() {
		return service.getAllLanguages();
	}
}
