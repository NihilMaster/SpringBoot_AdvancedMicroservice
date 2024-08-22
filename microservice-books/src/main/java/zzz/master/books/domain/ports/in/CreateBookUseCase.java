package zzz.master.books.domain.ports.in;

import zzz.master.books.domain.models.BookModel;

public interface CreateBookUseCase {

    BookModel createBook(BookModel book);
}
