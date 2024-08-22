package zzz.master.users.infrastructure.adapters.in.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import zzz.master.users.infrastructure.adapters.out.repositories.UserRepository;
import zzz.master.users.infrastructure.entities.UserEntity;

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

    public Mono<ServerResponse> createUser(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(UserEntity.class)
                .flatMap(userRepository::save)
                .flatMap(userSaved -> ServerResponse.ok().bodyValue(userSaved))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateUser(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(existingContact -> serverRequest.bodyToMono(UserEntity.class)
                        .flatMap(userEntity -> {
                            userEntity.setId(serverRequest.pathVariable("id")); // Asegurar que el ID sea el mismo
                            return userRepository.save(userEntity);
                        })
                        .flatMap(updatedContact -> ServerResponse.ok().bodyValue(updatedContact))
                )
                .switchIfEmpty(ServerResponse.notFound().build()); // Si no se encuentra el contacto
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        return userRepository.findById(serverRequest.pathVariable("id"))
                .flatMap(existingContact -> userRepository.delete(existingContact)
                        .then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
    
}
