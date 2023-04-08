package org.example.session.service.implementation;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.session.entity.SessionEntity;
import org.example.session.entity.WordEntity;
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

	private final Random random;

	@Override
	public Mono<Session> initializeSession(int userId, int languageId, int wordLength) {
		return getRandomWord(languageId, wordLength)
				.map(word ->
						SessionEntity.builder()
								.userId(userId)
								.languageId(languageId)
								.wordLength(wordLength)
								.wordNumber(word.getNumber())
								.build()
				)
				.flatMap(sessionRepository::save)
				.map(sessionMapper::entityToDto);
	}

	private Mono<WordEntity> getRandomWord(int languageId, int wordLength) {
		return wordRepository.countAllByLanguageIdAndLength(languageId, wordLength)
				.map(random::nextInt)
				.map(it -> it + 1)
				.flatMap(randomNumber -> wordRepository.findByLanguageIdAndLengthAndNumber(languageId, wordLength, randomNumber));
	}

	@Override
	public Mono<WordleResult> handleGuess(int userId, int sessionId, String guess) {
		return Mono.empty();
	}
}
