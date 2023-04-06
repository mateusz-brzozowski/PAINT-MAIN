package org.example.session.controller;

import lombok.RequiredArgsConstructor;
import org.example.session.service.WordleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public Mono<String> ping(@RequestParam(required = false) String name) {
		return Mono.justOrEmpty(name)
				.defaultIfEmpty("World")
				.map(it -> String.format("Hello, %s!", it))
				.flatMap(it -> service.test());
	}
}
