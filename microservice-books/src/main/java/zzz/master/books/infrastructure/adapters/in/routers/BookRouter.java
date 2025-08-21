package zzz.master.books.infrastructure.adapters.in.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import zzz.master.books.infrastructure.adapters.in.handlers.BookHandler;

@Configuration
public class BookRouter {

    @Bean
    public RouterFunction<ServerResponse> bookRoutes(BookHandler bookHandler) {
        return RouterFunctions
                .route()
                .path("/api", builder -> builder
                        .path("/books", booksBuilder -> booksBuilder
                                .GET("", bookHandler::getAll)          // /api/books
                                .GET("/", bookHandler::getAll)         // /api/books/
                                .GET("/available", bookHandler::getBooksWithAvailableCopiesGreaterThan)
                                .GET("/by-author/",bookHandler::getBooksByAuthor)
                        )
                        .path("/book", bookBuilder -> bookBuilder
                                .GET("/{id}", bookHandler::getById)
                                // .GET("/{id}/loan-count", bookHandler::getLoanCount)
                                .POST("", bookHandler::createBook)                    // /api/book
                                .POST("/", bookHandler::createBook)                   // /api/book/
                                .PUT("/{id}", bookHandler::updateBook)
                                .PUT("/{id}/availability-copies/{availability}", bookHandler::updateAvailability)
                                .PUT("/{id}/total-copies/{copies}", bookHandler::updateTotalCopies)
                                .PUT("/{id}/loan-count/{count}", bookHandler::updateLoanCount)
                                .DELETE("/{id}", bookHandler::deleteBook)
                        )
                )
                .build();
    }
}