package zzz.master.loans.application.services;

import zzz.master.loans.domain.models.LoanModel;
import zzz.master.loans.domain.ports.in.CreateLoanUseCase;
import zzz.master.loans.domain.ports.in.DeleteLoanUseCase;
import zzz.master.loans.domain.ports.in.RetrieveLoanUseCase;
import zzz.master.loans.domain.ports.in.UpdateLoanUseCase;

import java.util.List;
import java.util.Optional;

public class LoanService implements RetrieveLoanUseCase, CreateLoanUseCase, UpdateLoanUseCase, DeleteLoanUseCase {

    private final CreateLoanUseCase createLoanUseCase;
    private final DeleteLoanUseCase deleteLoanUseCase;
    private final UpdateLoanUseCase updateLoanUseCase;
    private final RetrieveLoanUseCase retrieveLoanUseCase;

    public LoanService(CreateLoanUseCase createLoanUseCase, DeleteLoanUseCase deleteLoanUseCase, UpdateLoanUseCase updateLoanUseCase, RetrieveLoanUseCase retrieveLoanUseCase) {
        this.createLoanUseCase = createLoanUseCase;
        this.deleteLoanUseCase = deleteLoanUseCase;
        this.updateLoanUseCase = updateLoanUseCase;
        this.retrieveLoanUseCase = retrieveLoanUseCase;
    }

    @Override
    public LoanModel createLoan(LoanModel loan) {
        return createLoanUseCase.createLoan(loan);
    }

    @Override
    public List<LoanModel> getAllLoans() {
        return retrieveLoanUseCase.getAllLoans();
    }

    @Override
    public Optional<LoanModel> getLoanById(Long id) {
        return retrieveLoanUseCase.getLoanById(id);
    }

    @Override
    public Optional<List<LoanModel>> getLoansFromUserById(Long userId) {
        return retrieveLoanUseCase.getLoansFromUserById(userId);
    }

    @Override
    public boolean deleteLoan(Long loanId) {
        return deleteLoanUseCase.deleteLoan(loanId);
    }

    @Override
    public Optional<LoanModel> updateLoan(LoanModel loan) {
        return updateLoanUseCase.updateLoan(loan);
    }
}
