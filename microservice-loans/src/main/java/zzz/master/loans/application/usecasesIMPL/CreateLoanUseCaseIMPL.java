package zzz.master.loans.application.usecasesIMPL;

import zzz.master.loans.domain.models.LoanModel;
import zzz.master.loans.domain.ports.in.CreateLoanUseCase;
import zzz.master.loans.domain.ports.out.LoanRepositoryPort;

public class CreateLoanUseCaseIMPL implements CreateLoanUseCase {

    private final LoanRepositoryPort loanRepositoryPort;

    public CreateLoanUseCaseIMPL(LoanRepositoryPort loanRepositoryPort) {
        this.loanRepositoryPort = loanRepositoryPort;
    }

    @Override
    public LoanModel createLoan(LoanModel loan) {
        return loanRepositoryPort.createLoan(loan);
    }
}
