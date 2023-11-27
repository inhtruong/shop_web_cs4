package com.example.shop_web.domain.dto;


import com.example.shop_web.domain.Role;
import com.example.shop_web.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegisterReqDTO {

    private String username;
    private String password;
    private String rePassword;
    private Long roleId;

    public User toUser(Role role) {
        return new User()
                .setUsername(username)
                .setPassword(password)
                .setRole(role)
                ;
    }
}
