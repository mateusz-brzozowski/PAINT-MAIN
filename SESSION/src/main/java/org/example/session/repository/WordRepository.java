package org.example.session.repository;

import org.example.session.entity.WordEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface WordRepository extends ReactiveCrudRepository<WordEntity, Long> {

	Mono<Integer> countAllByLanguageIdAndLength(int languageId, int length);

	Mono<WordEntity> findByLanguageIdAndLengthAndNumber(int languageId, int length, int number);
}
