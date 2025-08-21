package zzz.master.loans.infrastructure.adapters.in.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import zzz.master.loans.infrastructure.adapters.in.handlers.LoanHandler;

@Configuration
public class LoanRouter {

    @Bean
    public RouterFunction<ServerResponse> loanRoutes(LoanHandler loanHandler) {
        return RouterFunctions
                .route()
                .path("/api", builder -> builder
                        .path("/loans", loansBuilder -> loansBuilder
                                .GET("", loanHandler::getAll)          // /api/loans
                                .GET("/", loanHandler::getAll)         // /api/loans/
                                .GET("/user/{id}", loanHandler::getAllFromUserById)
                                .GET("/active/", loanHandler::getAllActive)
                                .GET("/overdue/", loanHandler::getAllOverdue)
                                .GET("/returned/", loanHandler::getAllReturned)
                        )
                        .path("/loan", loanBuilder -> loanBuilder
                                .GET("/{id}", loanHandler::getById)
                                .POST("", loanHandler::createLoan)                    // /api/loan
                                .POST("/", loanHandler::createLoan)                   // /api/loan/
                                .PUT("/{id}", loanHandler::updateLoan)
                                .PUT("/{id}/finish", loanHandler::updateFinishLoan)
                                .DELETE("/{id}", loanHandler::deleteLoan)
                        )
                )
                .build();
    }
}