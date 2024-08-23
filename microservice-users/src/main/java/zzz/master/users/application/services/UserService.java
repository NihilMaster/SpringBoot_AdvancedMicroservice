package zzz.master.users.application.services;

import org.springframework.stereotype.Service;
import zzz.master.users.domain.models.UserModel;
import zzz.master.users.domain.models.UserStatusEnum;
import zzz.master.users.domain.ports.in.CreateUserUseCase;
import zzz.master.users.domain.ports.in.DeleteUserUseCase;
import zzz.master.users.domain.ports.in.RetrieveUserUseCase;
import zzz.master.users.domain.ports.in.UpdateUserUseCase;

import java.util.List;
import java.util.Optional;

public class UserService implements CreateUserUseCase, DeleteUserUseCase, UpdateUserUseCase, RetrieveUserUseCase {
    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final RetrieveUserUseCase retrieveUserUseCase;

    public UserService(CreateUserUseCase createUserUseCase, DeleteUserUseCase deleteUserUseCase, UpdateUserUseCase updateUserUseCase, RetrieveUserUseCase retrieveUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.retrieveUserUseCase = retrieveUserUseCase;
    }

    @Override
    public UserModel createUser(UserModel user) {
        return createUserUseCase.createUser(user);
    }

    @Override
    public boolean deleteUser(Long userId) {
        return deleteUserUseCase.deleteUser(userId);
    }

    @Override
    public Optional<UserModel> getUser(Long userId) {
        return retrieveUserUseCase.getUser(userId);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return retrieveUserUseCase.getAllUsers();
    }

    @Override
    public UserStatusEnum getUserStatus(Long userId) {
        return retrieveUserUseCase.getUser(userId).get().getStatus();
    }

    @Override
    public Optional<UserModel> updateUser(UserModel userModel) {
        return updateUserUseCase.updateUser(userModel);
    }

    @Override
    public UserStatusEnum updateUserStatus(Long userId, UserStatusEnum userStatusEnum) {
        return updateUserUseCase.updateUserStatus(userId, userStatusEnum);
    }
}
