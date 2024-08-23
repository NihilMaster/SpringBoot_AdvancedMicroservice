package zzz.master.users.application.usercasesIMPL;

import zzz.master.users.domain.models.UserModel;
import zzz.master.users.domain.models.UserStatusEnum;
import zzz.master.users.domain.ports.in.UpdateUserUseCase;
import zzz.master.users.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class UpdateUserUseCaseIMPL implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserUseCaseIMPL(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<UserModel> updateUser(UserModel userModel) {
        return userRepositoryPort.updateUser(userModel);
    }

    @Override
    public UserStatusEnum updateUserStatus(Long userId, UserStatusEnum userStatusEnum) {
        return userRepositoryPort.updateUserStatus(userId, userStatusEnum);
    }
}
