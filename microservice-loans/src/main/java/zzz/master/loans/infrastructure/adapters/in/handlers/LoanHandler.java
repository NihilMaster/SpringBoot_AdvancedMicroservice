package zzz.master.loans.infrastructure.adapters.in.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import zzz.master.loans.infrastructure.adapters.out.repositories.LoanRepository;
import zzz.master.loans.infrastructure.entities.LoanEntity;

@Repository
public class LoanHandler {

    @Autowired
    private LoanRepository loanRepository;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok().body(loanRepository.findAll(), LoanEntity.class);
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        return loanRepository.findById(Long.valueOf(serverRequest.pathVariable("id")))
                .flatMap(loan -> ServerResponse.ok().bodyValue(loan))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createLoan(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(LoanEntity.class)
                .flatMap(loanRepository::save)
                .flatMap(loanSaved -> ServerResponse.ok().bodyValue(loanSaved))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateLoan(ServerRequest serverRequest) {
        return loanRepository.findById(Long.valueOf(serverRequest.pathVariable("id")))
                .flatMap(existingLoan -> serverRequest.bodyToMono(LoanEntity.class)
                        .flatMap(loanEntity -> {
                            loanEntity.setId(Long.valueOf(serverRequest.pathVariable("id"))); // Asegurar que el ID sea el mismo
                            return loanRepository.save(loanEntity);
                        })
                        .flatMap(updatedLoan -> ServerResponse.ok().bodyValue(updatedLoan))
                )
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> deleteLoan(ServerRequest serverRequest) {
        return loanRepository.findById(Long.valueOf(serverRequest.pathVariable("id")))
                .flatMap(existingLoan -> loanRepository.delete(existingLoan)
                        .then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
