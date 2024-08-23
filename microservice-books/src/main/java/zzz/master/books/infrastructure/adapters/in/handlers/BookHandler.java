package zzz.master.books.infrastructure.adapters.in.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import zzz.master.books.infrastructure.adapters.out.repositories.BookRepository;
import zzz.master.books.infrastructure.entities.BookEntity;

@Repository
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok().body(bookRepository.findAll(), BookEntity.class);
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        return bookRepository.findById(Long.valueOf(serverRequest.pathVariable("id")))
                .flatMap(book -> ServerResponse.ok().bodyValue(book))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createBook(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(BookEntity.class)
                .flatMap(bookRepository::save)
                .flatMap(bookSaved -> ServerResponse.ok().bodyValue(bookSaved))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateBook(ServerRequest serverRequest) {
        return bookRepository.findById(Long.valueOf(serverRequest.pathVariable("id")))
                .flatMap(existingBook -> serverRequest.bodyToMono(BookEntity.class)
                        .flatMap(bookEntity -> {
                            bookEntity.setId(Long.valueOf(serverRequest.pathVariable("id"))); // Asegurar que el ID sea el mismo
                            return bookRepository.save(bookEntity);
                        })
                        .flatMap(updatedBook -> ServerResponse.ok().bodyValue(updatedBook))
                )
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateAvailability(ServerRequest serverRequest) {
        return bookRepository.findById(Long.valueOf(serverRequest.pathVariable("id")))
                .flatMap(existingBook -> {
                    if(existingBook.getAvailableCopies().equals(Integer.valueOf(serverRequest.pathVariable("availability")))) {
                        return ServerResponse.ok().bodyValue("The availability is the same");
                    }
                    existingBook.setAvailableCopies(Integer.valueOf(serverRequest.pathVariable("availability")));
                    return bookRepository.save(existingBook)
                            .flatMap(updatedBook -> ServerResponse.ok().bodyValue(updatedBook));
                })
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateTotalCopies(ServerRequest serverRequest) {
        return bookRepository.findById(Long.valueOf(serverRequest.pathVariable("id")))
                .flatMap(existingBook -> {
                    if(existingBook.getTotalCopies().equals(Integer.valueOf(serverRequest.pathVariable("copies")))) {
                        return ServerResponse.ok().bodyValue("The total copies are the same");
                    }
                    existingBook.setTotalCopies(Integer.valueOf(serverRequest.pathVariable("copies")));
                    return bookRepository.save(existingBook)
                            .flatMap(updatedBook -> ServerResponse.ok().bodyValue(updatedBook));
                })
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> deleteBook(ServerRequest serverRequest) {
        return bookRepository.findById(Long.valueOf(serverRequest.pathVariable("id")))
                .flatMap(existingBook -> bookRepository.delete(existingBook)
                        .then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
