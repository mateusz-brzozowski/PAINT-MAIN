package org.example.session.repository;

import org.example.session.entity.WordEntity;
import org.example.session.entity.ids.WordId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface WordRepository extends ReactiveCrudRepository<WordEntity, WordId> {

	Mono<Long> countAllByLanguageId(int languageId);
}
