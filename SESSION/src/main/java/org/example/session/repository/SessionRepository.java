package org.example.session.repository;

import org.example.session.entity.SessionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends ReactiveCrudRepository<SessionEntity, Long> {
}
