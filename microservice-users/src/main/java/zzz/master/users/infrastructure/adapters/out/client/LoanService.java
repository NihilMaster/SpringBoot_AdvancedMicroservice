package zzz.master.users.infrastructure.adapters.out.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import zzz.master.users.application.usercasesIMPL.DTOs.LoanDTO;

@Service
public class LoanService {

    private final WebClient webClient;

    public LoanService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<LoanDTO> getLoansByUserId(Long userId) {
        return webClient
                .get()
                .uri("api/loans/user/{id}", userId)
                .retrieve()
                .bodyToFlux(LoanDTO.class);
    }
}
