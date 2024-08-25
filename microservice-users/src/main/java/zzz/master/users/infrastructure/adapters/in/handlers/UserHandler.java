package zzz.master.users.infrastructure.adapters.in.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import zzz.master.users.domain.models.UserStatusEnum;
import zzz.master.users.infrastructure.adapters.out.repositories.UserRepository;
import zzz.master.users.infrastructure.entities.UserEntity;

import java.util.Arrays;

@Component
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok().body(userRepository.findAll(), UserEntity.class);
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(user -> ServerResponse.ok().bodyValue(user))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getUserStatus(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(user -> ServerResponse.ok().bodyValue(user.getStatus()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getMaxLoansAllowed(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(user -> ServerResponse.ok().bodyValue(user.getMaxLoansAllowed()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createUser(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(UserEntity.class)
                .flatMap(userRepository::save)
                .flatMap(userSaved -> ServerResponse.ok().bodyValue(userSaved))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateUser(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(existingUser -> serverRequest.bodyToMono(UserEntity.class)
                        .flatMap(userEntity -> {
                            userEntity.setId(serverRequest.pathVariable("id")); // Asegurar que el ID sea el mismo
                            return userRepository.save(userEntity);
                        })
                        .flatMap(updatedContact -> ServerResponse.ok().bodyValue(updatedContact))
                )
                .switchIfEmpty(ServerResponse.notFound().build()); // Si no se encuentra el contacto
    }
    
    public Mono<ServerResponse> updateUserStatus(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(existingUser -> {
                    if(existingUser.getStatus().name().equals(serverRequest.pathVariable("status"))){
                        return ServerResponse.ok().bodyValue("The status is the same");
                    }
                    if (Arrays.stream(UserStatusEnum.values())
                            .anyMatch(e -> e.name().equalsIgnoreCase(serverRequest.pathVariable("status")))) {
                        existingUser.setStatus(UserStatusEnum.valueOf(serverRequest.pathVariable("status")));
                        return userRepository.save(existingUser)
                                .flatMap(updatedContact -> ServerResponse.ok().bodyValue(updatedContact));
                    }else{
                        return ServerResponse.badRequest().bodyValue("Invalid status: "
                                +serverRequest.pathVariable("status"));
                    }
                })
                .switchIfEmpty(ServerResponse.notFound().build()); // Si no se encuentra el contacto
    }

    public Mono<ServerResponse> updateLoanCount(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(existingUser -> {
                        System.out.println(existingUser.toString());
                        existingUser.setLoanCount(serverRequest.pathVariable("count").equals("null") ?
                                existingUser.getLoanCount() :
                                Integer.valueOf(serverRequest.pathVariable("count")));
                        return userRepository.save(existingUser)
                                .flatMap(updatedContact -> ServerResponse.ok()
                                        .bodyValue(updatedContact.getLoanCount()));
                    }
                )
                .switchIfEmpty(ServerResponse.notFound().build()); // Si no se encuentra el contacto
    }

    public Mono<ServerResponse> updateMaxLoansAllowed(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(existingUser -> {
                        existingUser.setMaxLoansAllowed(serverRequest.pathVariable("max").equals("null") ?
                                existingUser.getMaxLoansAllowed() :
                                Integer.valueOf(serverRequest.pathVariable("max")));
                        return userRepository.save(existingUser)
                                .flatMap(updatedContact -> ServerResponse.ok()
                                        .bodyValue(updatedContact.getMaxLoansAllowed()));
                        }
                )
                .switchIfEmpty(ServerResponse.notFound().build()); // Si no se encuentra el contacto
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(existingUser -> userRepository.delete(existingUser)
                        .then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
    
}
