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
                .path("/api", builder -> builder
                        .path("/users", usersBuilder -> usersBuilder
                                .GET("", userHandler::getAll)          // /api/users
                                .GET("/", userHandler::getAll)         // /api/users/
                        )
                        .path("/user", userBuilder -> userBuilder
                                .GET("/{id}", userHandler::getById)
                                .GET("/{id}/status", userHandler::getUserStatus)
                                .GET("/{id}/max-loans-allowed", userHandler::getMaxLoansAllowed)
                                .GET("/{id}/loans", userHandler::getLoansForUser)
                                .GET("/{id}/loans-active", userHandler::getActiveLoansForUser)
                                .GET("/{id}/rate", userHandler::getUserRate)
                                .GET("/{id}/loans-count", userHandler::getUserLoanCount)
                                .GET("/by-email/", userHandler::getUserByEmail)
                                .POST("", userHandler::createUser)                    // /api/user
                                .POST("/", userHandler::createUser)                   // /api/user/
                                .PUT("/{id}", userHandler::updateUser)
                                .PUT("/{id}/status/{status}", userHandler::updateUserStatus)
                                .PUT("/{id}/loans-count/{count}", userHandler::updateLoanCount)
                                .PUT("/{id}/max-loans-allowed/{max}", userHandler::updateMaxLoansAllowed)
                                .DELETE("/{id}", userHandler::deleteUser)
                        )
                )
                .build();
    }
}
