package zzz.master.loans.application.usecasesIMPL;

import zzz.master.loans.domain.models.LoanModel;
import zzz.master.loans.domain.ports.in.RetrieveLoanUseCase;
import zzz.master.loans.domain.ports.out.LoanRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveLoanUseCaseIMPL implements RetrieveLoanUseCase {

    private final LoanRepositoryPort loanRepositoryPort;

    public RetrieveLoanUseCaseIMPL(LoanRepositoryPort loanRepositoryPort) {
        this.loanRepositoryPort = loanRepositoryPort;
    }

    @Override
    public List<LoanModel> getAllLoans() {
        return loanRepositoryPort.getAllLoans();
    }

    @Override
    public Optional<LoanModel> getLoanById(Long id) {
        return loanRepositoryPort.getLoanById(id);
    }
}
