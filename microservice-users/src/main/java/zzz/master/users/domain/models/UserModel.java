package zzz.master.users.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserModel {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private LocalDate memberSince;
    private UserStatusEnum status;
    private Integer loanCount;
    private Integer maxLoansAllowed;
}
