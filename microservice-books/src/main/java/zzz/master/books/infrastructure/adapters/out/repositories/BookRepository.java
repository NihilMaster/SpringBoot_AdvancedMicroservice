package zzz.master.books.infrastructure.adapters.out.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import zzz.master.books.infrastructure.entities.BookEntity;

public interface BookRepository extends ReactiveCrudRepository<BookEntity, Long> {
}
