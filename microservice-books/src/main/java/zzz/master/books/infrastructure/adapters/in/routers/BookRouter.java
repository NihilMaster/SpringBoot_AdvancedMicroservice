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
                .GET("/api/books", bookHandler::getAll)
                .GET("/api/book/{id}", bookHandler::getById)
                .POST("/api/book", bookHandler::createBook)
                .PUT("/api/book/{id}", bookHandler::updateBook)
                .PUT("/api/book/{id}/availability-copies/{availability}", bookHandler::updateAvailability)
                .PUT("/api/book/{id}/total-copies/{copies}", bookHandler::updateTotalCopies)
                .PUT("/api/book/{id}/loan-count/{count}", bookHandler::updateLoanCount)
                .DELETE("/api/book/{id}", bookHandler::deleteBook)
                .build();
    }
}
