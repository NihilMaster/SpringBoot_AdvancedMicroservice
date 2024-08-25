package zzz.master.books.application.services;

import zzz.master.books.domain.models.BookModel;
import zzz.master.books.domain.ports.in.CreateBookUseCase;
import zzz.master.books.domain.ports.in.DeleteBookUseCase;
import zzz.master.books.domain.ports.in.RetrieveBookUseCase;
import zzz.master.books.domain.ports.in.UpdateBookUseCase;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class BookService implements CreateBookUseCase, UpdateBookUseCase, DeleteBookUseCase, RetrieveBookUseCase {

    private final CreateBookUseCase createBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final RetrieveBookUseCase retrieveBookUseCase;

    public BookService(CreateBookUseCase createBookUseCase, UpdateBookUseCase updateBookUseCase, DeleteBookUseCase deleteBookUseCase, RetrieveBookUseCase retrieveBookUseCase) {
        this.createBookUseCase = createBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.retrieveBookUseCase = retrieveBookUseCase;
    }

    @Override
    public BookModel createBook(BookModel book) {
        return createBookUseCase.createBook(book);
    }

    @Override
    public Optional<BookModel> getBookById(Long bookId) {
        return retrieveBookUseCase.getBookById(bookId);
    }

    @Override
    public List<BookModel> getAllBooks() {
        return retrieveBookUseCase.getAllBooks();
    }

    @Override
    public Optional<BookModel> updateBook(BookModel book) {
        return updateBookUseCase.updateBook(book);
    }

    @Override
    public OptionalInt updateAvailableCopies(Long bookId, Integer availableCopies) {
        return updateBookUseCase.updateAvailableCopies(bookId, availableCopies);
    }

    @Override
    public OptionalInt updateTotalCopies(Long bookId, Integer totalCopies) {
        return updateBookUseCase.updateTotalCopies(bookId, totalCopies);
    }

    @Override
    public OptionalInt updateLoanCount(Long bookId, Integer loanCount) {
        return updateBookUseCase.updateLoanCount(bookId, loanCount);
    }

    @Override
    public boolean deleteBook(Long bookId) {
        return deleteBookUseCase.deleteBook(bookId);
    }

}
