package zzz.master.loans.domain.ports.in;

import zzz.master.loans.domain.models.LoanModel;

public interface CreateLoanUseCase {

    LoanModel createLoan(LoanModel loan);
}
