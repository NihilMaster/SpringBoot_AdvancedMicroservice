package zzz.master.users.domain.ports.in;

import zzz.master.users.domain.models.UserModel;
import zzz.master.users.domain.models.UserStatusEnum;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {

    Optional<UserModel> getUser(Long userId);
    List<UserModel> getAllUsers();
    UserStatusEnum getUserStatus(Long userId);
    Integer getMaxLoansAllowed(Long userId);
}
