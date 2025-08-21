package zzz.master.loans.infrastructure.adapters.out.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import zzz.master.loans.domain.models.LoanStatusEnum;
import zzz.master.loans.infrastructure.entities.LoanEntity;

public interface LoanRepository extends ReactiveCrudRepository<LoanEntity, Long> {

    Flux<LoanEntity> findAllByUserId(Long userId);
    Flux<LoanEntity> findAllByStatus(LoanStatusEnum status);

    // Métodos específicos para cada estado (de todos los usuarios)
    default Flux<LoanEntity> findAllActive() {
        return findAllByStatus(LoanStatusEnum.ACTIVE);
    }

    default Flux<LoanEntity> findAllOverdue() {
        return findAllByStatus(LoanStatusEnum.OVERDUE);
    }

    default Flux<LoanEntity> findAllReturned() {
        return findAllByStatus(LoanStatusEnum.RETURNED);
    }
}
