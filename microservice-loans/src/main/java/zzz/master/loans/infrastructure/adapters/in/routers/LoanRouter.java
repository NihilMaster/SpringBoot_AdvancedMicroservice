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
                .GET("/api/loans", loanHandler::getAll)
                .GET("/api/loan/{id}", loanHandler::getById)
                .GET("/api/loans/user/{id}", loanHandler::getAllFromUserById)
                .POST("/api/loan", loanHandler::createLoan)
                .PUT("/api/loan/{id}", loanHandler::updateLoan)
                .PUT("/api/loan/finish/{id}", loanHandler::updateFinishLoan)
                .DELETE("/api/loan/{id}", loanHandler::deleteLoan)
                .build();
    }
}
