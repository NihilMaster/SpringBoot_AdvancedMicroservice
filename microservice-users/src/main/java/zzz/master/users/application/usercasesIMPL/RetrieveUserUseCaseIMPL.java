package zzz.master.users.application.usercasesIMPL;

import zzz.master.users.domain.models.UserModel;
import zzz.master.users.domain.ports.in.RetrieveUserUseCase;
import zzz.master.users.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveUserUseCaseIMPL implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public RetrieveUserUseCaseIMPL(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<UserModel> getUser(Long userId) {
        return userRepositoryPort.getUserById(userId);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepositoryPort.getAllUsers();
    }
}
