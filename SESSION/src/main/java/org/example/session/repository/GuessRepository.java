package org.example.session.repository;

import org.example.session.entity.GuessEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface GuessRepository extends ReactiveCrudRepository<GuessEntity, Long> {

	Mono<Integer> countAllBySessionId(long sessionId);
}
