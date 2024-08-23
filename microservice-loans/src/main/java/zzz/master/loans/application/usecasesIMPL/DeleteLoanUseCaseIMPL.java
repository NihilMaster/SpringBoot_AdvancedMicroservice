package zzz.master.loans.application.usecasesIMPL;

import zzz.master.loans.domain.ports.in.DeleteLoanUseCase;

public class DeleteLoanUseCaseIMPL implements DeleteLoanUseCase {

    private final DeleteLoanUseCase deleteLoanUseCase;

    public DeleteLoanUseCaseIMPL(DeleteLoanUseCase deleteLoanUseCase) {
        this.deleteLoanUseCase = deleteLoanUseCase;
    }

    @Override
    public boolean deleteLoan(Long loanId) {
        return deleteLoanUseCase.deleteLoan(loanId);
    }
}
