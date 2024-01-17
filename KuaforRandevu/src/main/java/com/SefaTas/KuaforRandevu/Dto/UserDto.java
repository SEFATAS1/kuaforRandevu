package com.SefaTas.KuaforRandevu.Dto;

import com.SefaTas.KuaforRandevu.Entity.User;
import com.SefaTas.KuaforRandevu.Exception.Validation.UniqueEmail;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto{
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private Long userRoleId;
}
