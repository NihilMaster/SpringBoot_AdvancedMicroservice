package zzz.master.users.domain.ports.in;

import zzz.master.users.domain.models.UserModel;

public interface CreateUserUseCase {

    UserModel createUser(UserModel user);
}
