package zzz.master.books.application.usecasesIMPL;

import zzz.master.books.domain.models.BookModel;
import zzz.master.books.domain.ports.in.CreateBookUseCase;
import zzz.master.books.domain.ports.out.BookRepositoryPort;

public class CreateBookUseCaseIMPL implements CreateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public CreateBookUseCaseIMPL(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public BookModel createBook(BookModel book) {
        return bookRepositoryPort.createBook(book);
    }
}
