package zzz.master.books.domain.ports.out;

import zzz.master.books.domain.models.BookModel;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryPort {

    BookModel createBook(BookModel bookModel);
    Optional<BookModel> getBookById(Long bookId);
    List<BookModel> getAllBooks();
    Optional<BookModel> updateBook(BookModel bookModel);
    boolean deleteBook(Long bookId);
}
