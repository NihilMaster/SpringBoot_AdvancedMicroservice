package zzz.master.users.domain.ports.in;

import zzz.master.users.domain.models.UserModel;

import java.util.Optional;

public interface UpdateUserUseCase {

    Optional<UserModel> updateUser(UserModel userModel);
}
