package zzz.master.books.application.usecasesIMPL;

import zzz.master.books.domain.models.BookModel;
import zzz.master.books.domain.ports.in.RetrieveBookUseCase;
import zzz.master.books.domain.ports.out.BookRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveBookUseCaseIMPL implements RetrieveBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public RetrieveBookUseCaseIMPL(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public Optional<BookModel> getBookById(Long bookId) {
        return bookRepositoryPort.getBookById(bookId);
    }

    @Override
    public List<BookModel> getAllBooks() {
        return bookRepositoryPort.getAllBooks();
    }
}
