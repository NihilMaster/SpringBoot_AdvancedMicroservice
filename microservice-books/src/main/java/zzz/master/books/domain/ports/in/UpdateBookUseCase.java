package zzz.master.books.domain.ports.in;

import zzz.master.books.domain.models.BookModel;

import java.util.Optional;

public interface UpdateBookUseCase {

    Optional<BookModel> updateBook(BookModel book);
}
