package org.example.session.repository;

import org.example.session.entity.LanguageEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends ReactiveCrudRepository<LanguageEntity, Integer> {
}
