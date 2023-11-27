package com.example.shop_web.service.user;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.User;
import com.example.shop_web.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface IUserService extends IGeneralService<User, Long>, UserDetailsService {

    Boolean existsByUsername(String username);

    User getByUsername(String username);
}
