package zzz.master.books.application.usecasesIMPL;

import zzz.master.books.domain.ports.in.DeleteBookUseCase;
import zzz.master.books.domain.ports.out.BookRepositoryPort;

public class DeleteBookUseCaseIMPL implements DeleteBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public DeleteBookUseCaseIMPL(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public boolean deleteBook(Long bookId) {
        return bookRepositoryPort.deleteBook(bookId);
    }
}
