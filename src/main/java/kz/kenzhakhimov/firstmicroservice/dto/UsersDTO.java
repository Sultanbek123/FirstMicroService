package kz.kenzhakhimov.firstmicroservice.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import kz.kenzhakhimov.firstmicroservice.entities.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDTO {
    private Long id;
    private String fullName;
    private int age;
    private String email;
    private String password;
    private String rePassword;
    private List<Permission> permissions;
}
