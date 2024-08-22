package zzz.master.users.application.usercasesIMPL;

import zzz.master.users.domain.models.UserModel;
import zzz.master.users.domain.ports.in.CreateUserUseCase;
import zzz.master.users.domain.ports.out.UserRepositoryPort;

public class CreateUserUseCaseIMPL implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseIMPL(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserModel createUser(UserModel user) {
        return userRepositoryPort.createUser(user);
    }
}
