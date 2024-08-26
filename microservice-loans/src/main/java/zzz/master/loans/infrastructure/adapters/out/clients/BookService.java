package zzz.master.loans.infrastructure.adapters.out.clients;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import zzz.master.loans.application.usecasesIMPL.DTOs.BookDTO;

@Service
public class BookService {

    private final WebClient webClient;

    public BookService(@Qualifier("webClientBook") WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<BookDTO> getBookById(Long id) {
        return webClient
                .get()
                .uri("api/book/{id}", id)
                .retrieve()
                .bodyToMono(BookDTO.class);
    }

    public Mono<Integer> updateBookAvailableCopies(Long id, Integer availableCopies) {
        return webClient
                .put()
                .uri("api/book/{id}/availability-copies/{availability}", id, availableCopies)
                .retrieve()
                .bodyToMono(Integer.class);
    }
}
