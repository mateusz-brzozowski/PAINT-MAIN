package org.example.session.controller;

import lombok.RequiredArgsConstructor;
import org.example.session.model.Session;
import org.example.session.model.WordleResult;
import org.example.session.service.WordleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("wordle")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WordleController {

	private final WordleService service;

	@GetMapping
	public Mono<Session> initializeSession(
			@RequestParam Integer languageId,
			@RequestHeader(required = false, defaultValue = "5") Integer wordLength
	) {
		// TODO: implement different modes
		var userId = 1; // TODO: retrieve user id from provided token
		return service.initializeSession(userId, languageId, wordLength);
	}

	@PostMapping
	public Mono<WordleResult> guess(
			@RequestHeader Integer sessionId,
			@RequestBody String guess
	) {
		var userId = 1; // TODO: retrieve user id from provided token
		return service.handleGuess(userId, sessionId, guess);
	}
}
