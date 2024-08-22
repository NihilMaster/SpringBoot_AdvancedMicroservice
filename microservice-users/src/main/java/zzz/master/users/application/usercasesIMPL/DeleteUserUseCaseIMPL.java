package zzz.master.users.application.usercasesIMPL;

import zzz.master.users.domain.ports.in.DeleteUserUseCase;
import zzz.master.users.domain.ports.out.UserRepositoryPort;

public class DeleteUserUseCaseIMPL implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public DeleteUserUseCaseIMPL(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public boolean deleteUser(Long userId) {
        return userRepositoryPort.deleteUser(userId);
    }
}
