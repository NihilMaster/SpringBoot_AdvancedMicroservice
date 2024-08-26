package zzz.master.loans.infrastructure.adapters.in.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import zzz.master.loans.domain.models.LoanStatusEnum;
import zzz.master.loans.infrastructure.adapters.out.clients.BookService;
import zzz.master.loans.infrastructure.adapters.out.clients.UserService;
import zzz.master.loans.infrastructure.adapters.out.repositories.LoanRepository;
import zzz.master.loans.infrastructure.entities.LoanEntity;

import java.time.LocalDate;

@Repository
public class LoanHandler {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok().body(loanRepository.findAll(), LoanEntity.class);
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        return loanRepository.findById(Long.valueOf(serverRequest.pathVariable("id")))
                .flatMap(loan -> ServerResponse.ok().bodyValue(loan))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getAllFromUserById(ServerRequest serverRequest) {
        Flux<LoanEntity> loans = loanRepository.findAllByUserId(Long.valueOf(serverRequest.pathVariable("id")));
        System.out.println(loans);
        return ServerResponse.ok().body(loans, LoanEntity.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createLoan(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(LoanEntity.class)
                .flatMap(loanEntity -> {
                    return userService.getUserStatusById(loanEntity.getUserId())
                            .flatMap(userStatus -> {
                                return userService.getUserMaxLoansAllowedById(loanEntity.getUserId())
                                        .flatMap(userMaxLoans -> {
                                            if (userStatus.equals("\"ACTIVE\"") && userMaxLoans > 0) {
                                                return bookService.getBookById(loanEntity.getBookId())
                                                        .flatMap(book -> {
                                                            if(book.getAvailableCopies() > 0) {
                                                                loanEntity.setLoanDate(LocalDate.now());
                                                                loanEntity.setDueDate(loanEntity.getLoanDate().plusDays(10));
                                                                loanEntity.setStatus(LoanStatusEnum.ACTIVE);
                                                                return loanRepository.save(loanEntity)
                                                                        .flatMap(loanSaved -> {
                                                                            return userService.getUserLoanCount(loanSaved.getUserId())
                                                                                    .flatMap(userLoanCount -> {
                                                                                        return userService.updateUserLoanCount(loanSaved.getUserId(),userLoanCount)
                                                                                                .flatMap(userLoan ->  bookService.updateBookAvailableCopies(loanSaved.getBookId(), book.getAvailableCopies() - 1)
                                                                                                            .flatMap(bookUpdated -> ServerResponse.ok().bodyValue(loanSaved)));
                                                                                    });
                                                                        })
                                                                        .switchIfEmpty(ServerResponse.notFound().build());
                                                            }
                                                            return ServerResponse.badRequest().bodyValue("No hay libros disponibles");
                                                        }).switchIfEmpty(ServerResponse.notFound().build());
                                            } else {
                                                return ServerResponse.notFound().build();
                                            }
                                        });
                            });
                });
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
