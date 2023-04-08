package org.example.session.service;

import org.example.session.model.Session;
import org.example.session.model.WordleResult;
import reactor.core.publisher.Mono;

public interface WordleService {

	Mono<Session> initializeSession(int userId, int languageId, int wordLength);

	Mono<WordleResult> handleGuess(int userId, long sessionId, String guess);
}
