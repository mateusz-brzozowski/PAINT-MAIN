package org.example.session.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.session.entity.SessionEntity;
import org.example.session.mapper.SessionMapper;
import org.example.session.model.Session;
import org.example.session.model.WordleResult;
import org.example.session.repository.GuessRepository;
import org.example.session.repository.SessionRepository;
import org.example.session.repository.WordRepository;
import org.example.session.service.WordleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WordleServiceImpl implements WordleService {

	private final WordRepository wordRepository;
	private final SessionRepository sessionRepository;
	private final GuessRepository guessRepository;

	private final SessionMapper sessionMapper;

	@Override
	public Mono<Session> initializeSession(int userId, int languageId, int wordLength) {
		var word = wordRepository.countAllByLanguageId(languageId);
		var session = SessionEntity.builder()
				.userId(userId)
				.wordLength(wordLength)
				.build();
		return null;
	}

	@Override
	public Mono<WordleResult> handleGuess(int userId, int sessionId, String guess) {
		return null;
	}
}
