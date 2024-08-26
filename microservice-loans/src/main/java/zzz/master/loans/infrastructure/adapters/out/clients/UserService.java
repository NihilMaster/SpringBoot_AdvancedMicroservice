package zzz.master.loans.infrastructure.adapters.out.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final WebClient webClient;

    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getUserStatusById(Long userId) {
        return webClient
                .get()
                .uri("api/user/{id}/status", userId)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<Integer> getUserMaxLoansAllowedById(Long userId) {
        return webClient
                .get()
                .uri("api/user/{id}/max-loans-allowed", userId)
                .retrieve()
                .bodyToMono(Integer.class);
    }

    public Mono<Integer> getUserLoanCount(Long userId) {
        return webClient
                .get()
                .uri("api/user/{id}/loans-count", userId)
                .retrieve()
                .bodyToMono(Integer.class);
    }

    public Mono<Integer> updateUserLoanCount(Long userId, Integer loanCount) {
        return webClient
                .put()
                .uri("api/user/{id}/loans-count/{count}", userId, loanCount)
                .retrieve()
                .bodyToMono(Integer.class);
    }

}
