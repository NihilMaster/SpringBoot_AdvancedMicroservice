package zzz.master.users.infrastructure.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import zzz.master.users.domain.models.UserStatusEnum;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Document(collection = "users")
@Data
public class UserEntity {

    @Id
    private String id;
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
