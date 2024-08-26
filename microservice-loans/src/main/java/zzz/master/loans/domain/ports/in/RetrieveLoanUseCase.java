package zzz.master.loans.domain.ports.in;

import zzz.master.loans.domain.models.LoanModel;

import java.util.List;
import java.util.Optional;

public interface RetrieveLoanUseCase {

    List<LoanModel> getAllLoans();
    Optional<LoanModel> getLoanById(Long id);
    Optional<List<LoanModel>> getLoansFromUserById(Long userId);
}
