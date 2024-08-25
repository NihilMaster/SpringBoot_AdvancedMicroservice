package zzz.master.books.domain.ports.in;

import zzz.master.books.domain.models.BookModel;

import java.util.Optional;
import java.util.OptionalInt;

public interface UpdateBookUseCase {

    Optional<BookModel> updateBook(BookModel book);
    OptionalInt updateAvailableCopies(Long bookId, Integer availableCopies);
    OptionalInt updateTotalCopies(Long bookId, Integer totalCopies);
    OptionalInt updateLoanCount(Long bookId, Integer loanCount);
}
