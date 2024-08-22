package zzz.master.books.domain.ports.in;

import zzz.master.books.domain.models.BookModel;

import java.util.List;
import java.util.Optional;

public interface RetrieveBookUseCase {

    Optional<BookModel> getBookById(Long bookId);
    List<BookModel> getAllBooks();
}
