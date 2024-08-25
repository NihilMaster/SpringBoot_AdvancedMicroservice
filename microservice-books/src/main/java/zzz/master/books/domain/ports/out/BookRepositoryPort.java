package zzz.master.books.domain.ports.out;

import zzz.master.books.domain.models.BookModel;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface BookRepositoryPort {

    BookModel createBook(BookModel bookModel);
    Optional<BookModel> getBookById(Long bookId);
    List<BookModel> getAllBooks();
    Optional<BookModel> updateBook(BookModel bookModel);
    OptionalInt updateAvailableCopies(Long bookId, Integer availableCopies);
    OptionalInt updateTotalCopies(Long bookId, Integer totalCopies);
    OptionalInt updateLoanCount(Long bookId, Integer loanCount);
    boolean deleteBook(Long bookId);
}
