package zzz.master.loans.infrastructure.adapters.out.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import zzz.master.loans.infrastructure.entities.LoanEntity;

public interface LoanRepository extends ReactiveCrudRepository<LoanEntity, Long> {

    Flux<LoanEntity> findAllByUserId(Long userId);
}
