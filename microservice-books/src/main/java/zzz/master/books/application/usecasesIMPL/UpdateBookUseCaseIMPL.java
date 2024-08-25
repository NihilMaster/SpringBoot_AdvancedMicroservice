package zzz.master.books.application.usecasesIMPL;

import zzz.master.books.domain.models.BookModel;
import zzz.master.books.domain.ports.in.UpdateBookUseCase;
import zzz.master.books.domain.ports.out.BookRepositoryPort;

import java.util.Optional;
import java.util.OptionalInt;

public class UpdateBookUseCaseIMPL implements UpdateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public UpdateBookUseCaseIMPL(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public Optional<BookModel> updateBook(BookModel book) {
        return bookRepositoryPort.updateBook(book);
    }

    @Override
    public OptionalInt updateAvailableCopies(Long bookId, Integer availableCopies) {
        return bookRepositoryPort.updateAvailableCopies(bookId, availableCopies);
    }

    @Override
    public OptionalInt updateTotalCopies(Long bookId, Integer totalCopies) {
        return bookRepositoryPort.updateTotalCopies(bookId, totalCopies);
    }

    @Override
    public OptionalInt updateLoanCount(Long bookId, Integer loanCount) {
        return bookRepositoryPort.updateLoanCount(bookId, loanCount);
    }
}
