package zzz.master.users.domain.ports.in;

import zzz.master.users.domain.models.UserModel;
import zzz.master.users.domain.models.UserStatusEnum;

import java.util.Optional;

public interface UpdateUserUseCase {

    Optional<UserModel> updateUser(UserModel userModel);
    UserStatusEnum updateUserStatus(Long userId, UserStatusEnum userStatusEnum);
    Integer updateLoanCount(Long userId, Integer loanCount);
    Integer updateMaxLoansAllowed(Long userId, Integer maxLoansAllowed);
}
