package org.example.session.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.session.entity.SessionEntity;
import org.example.session.entity.WordEntity;
import org.example.session.repository.SessionRepository;
import org.example.session.repository.WordRepository;
import org.example.session.service.WordleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WordleServiceImpl implements WordleService {

	private final SessionRepository sessionRepository;
	private final WordRepository wordRepository;

	@Override
	public Mono<String> test() {
		var session = sessionRepository.save(SessionEntity.builder().build());
		var word = wordRepository.save(WordEntity.builder().build());
		return Flux.concat(
				session,
				word
		).reduce("", (a, b) -> a + b.toString());
	}
}
