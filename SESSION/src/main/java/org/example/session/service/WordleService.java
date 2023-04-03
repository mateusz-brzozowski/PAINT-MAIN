package org.example.session.service;

import reactor.core.publisher.Mono;

public interface WordleService {

	Mono<String> test();
}
