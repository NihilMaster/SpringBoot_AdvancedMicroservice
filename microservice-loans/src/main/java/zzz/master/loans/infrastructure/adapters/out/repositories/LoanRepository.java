package zzz.master.loans.infrastructure.adapters.out.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import zzz.master.loans.infrastructure.entities.LoanEntity;

public interface LoanRepository extends ReactiveCrudRepository<LoanEntity, Long> {
}
