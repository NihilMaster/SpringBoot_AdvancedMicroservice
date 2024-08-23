package zzz.master.loans.domain.ports.in;

import zzz.master.loans.domain.models.LoanModel;

import java.util.Optional;

public interface UpdateLoanUseCase {

    Optional<LoanModel> updateLoan(LoanModel loan);
}
