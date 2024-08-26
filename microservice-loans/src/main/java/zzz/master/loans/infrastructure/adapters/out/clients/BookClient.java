package zzz.master.loans.infrastructure.adapters.out.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BookClient {

    @Bean
    public WebClient webClientBook() {
        return WebClient.builder()
                .baseUrl("http://localhost:4444")
                .build();
    }
}
