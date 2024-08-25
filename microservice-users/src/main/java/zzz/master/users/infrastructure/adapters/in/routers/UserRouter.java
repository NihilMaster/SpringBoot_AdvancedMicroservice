package zzz.master.users.infrastructure.adapters.in.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import zzz.master.users.infrastructure.adapters.in.handlers.UserHandler;

@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler) {
        return RouterFunctions
                .route()
                .GET("/api/users", userHandler::getAll)
                .GET("/api/user/{id}", userHandler::getById)
                .GET("/api/user/{id}/status", userHandler::getUserStatus)
                .GET("/api/user/{id}/max-loans-allowed", userHandler::getMaxLoansAllowed)
                .POST("/api/user", userHandler::createUser)
                .PUT("/api/user/{id}", userHandler::updateUser)
                .PUT("/api/user/{id}/status/{status}", userHandler::updateUserStatus)
                .PUT("/api/user/{id}/loans-count/{count}", userHandler::updateLoanCount)
                .PUT("/api/user/{id}/max-loans-allowed/{max}", userHandler::updateMaxLoansAllowed)
                .DELETE("/api/user/{id}", userHandler::deleteUser)
                .build();
    }
}
