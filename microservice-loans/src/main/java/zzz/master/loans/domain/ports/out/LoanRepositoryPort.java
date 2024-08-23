package zzz.master.loans.domain.ports.out;

import zzz.master.loans.domain.models.LoanModel;

import java.util.List;
import java.util.Optional;

public interface LoanRepositoryPort {

    LoanModel createLoan(LoanModel loanModel);
    List<LoanModel> getAllLoans();
    Optional<LoanModel> getLoanById(Long loanId);
    Optional<LoanModel> updateLoan(LoanModel loanModel);
    boolean deleteLoan(Long loanId);
}
