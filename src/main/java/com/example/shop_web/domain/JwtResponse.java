package com.example.shop_web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {

    private Long id;
    private String token;
    private String type = "Bearer";
    private String userName;
    private String name;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, Long id, String userName, String name, Collection<? extends GrantedAuthority> roles) {
        this.token = accessToken;
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", username='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
