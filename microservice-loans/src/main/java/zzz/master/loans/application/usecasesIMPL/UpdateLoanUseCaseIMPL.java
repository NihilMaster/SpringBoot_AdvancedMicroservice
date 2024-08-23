package zzz.master.loans.application.usecasesIMPL;

import zzz.master.loans.domain.models.LoanModel;
import zzz.master.loans.domain.ports.in.UpdateLoanUseCase;
import zzz.master.loans.domain.ports.out.LoanRepositoryPort;

import java.util.Optional;

public class UpdateLoanUseCaseIMPL implements UpdateLoanUseCase {

    private final LoanRepositoryPort loanRepositoryPort;

    public UpdateLoanUseCaseIMPL(LoanRepositoryPort loanRepositoryPort) {
        this.loanRepositoryPort = loanRepositoryPort;
    }

    @Override
    public Optional<LoanModel> updateLoan(LoanModel loan) {
        return loanRepositoryPort.updateLoan(loan);
    }
}
