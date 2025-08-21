package zzz.master.books.infrastructure.adapters.out.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import zzz.master.books.infrastructure.entities.BookEntity;

public interface BookRepository extends ReactiveCrudRepository<BookEntity, Long> {

    Flux<BookEntity> findByAvailableCopiesGreaterThan(Integer value);
    Flux<BookEntity> findBookByAuthor(String author);
}
