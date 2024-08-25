package zzz.master.users.domain.ports.out;

import zzz.master.users.domain.models.UserModel;
import zzz.master.users.domain.models.UserStatusEnum;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    UserModel createUser(UserModel userModel);
    Optional<UserModel> getUserById(Long userId);
    List<UserModel> getAllUsers();
    UserStatusEnum getUserStatus(Long userId);
    Integer getMaxLoansAllowed(Long userId);
    Optional<UserModel> updateUser(UserModel userModel);
    Integer updateLoanCount(Long userId, Integer actualLoansAllowed);
    Integer updateMaxLoansAllowed(Long userId, Integer maxLoansAllowed);
    UserStatusEnum updateUserStatus(Long userId, UserStatusEnum userStatusEnum);
    boolean deleteUser(Long userId);
}
