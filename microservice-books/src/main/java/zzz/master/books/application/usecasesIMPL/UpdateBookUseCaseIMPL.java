package zzz.master.books.application.usecasesIMPL;

import zzz.master.books.domain.models.BookModel;
import zzz.master.books.domain.ports.in.UpdateBookUseCase;
import zzz.master.books.domain.ports.out.BookRepositoryPort;

import java.util.Optional;

public class UpdateBookUseCaseIMPL implements UpdateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public UpdateBookUseCaseIMPL(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public Optional<BookModel> updateBook(BookModel book) {
        return bookRepositoryPort.updateBook(book);
    }
}
