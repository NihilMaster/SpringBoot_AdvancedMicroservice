package zzz.master.users.domain.ports.out;

import zzz.master.users.domain.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    UserModel createUser(UserModel userModel);
    Optional<UserModel> getUserById(Long userId);
    List<UserModel> getAllUsers();
    Optional<UserModel> updateUser(UserModel userModel);
    boolean deleteUser(Long userId);
}
