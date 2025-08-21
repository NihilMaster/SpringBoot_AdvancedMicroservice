package zzz.master.users.infrastructure.adapters.out.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import zzz.master.users.infrastructure.entities.UserEntity;

public interface UserRepository extends ReactiveMongoRepository<UserEntity, String> {

    Mono<UserEntity> findUserByEmail(String email);
}
