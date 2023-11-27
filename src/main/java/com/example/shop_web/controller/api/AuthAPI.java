
package com.example.shop_web.controller.api;

import com.example.shop_web.domain.JwtResponse;
import com.example.shop_web.domain.Role;
import com.example.shop_web.domain.User;
import com.example.shop_web.domain.dto.UserRegisterReqDTO;
import com.example.shop_web.exception.DataInputException;
import com.example.shop_web.exception.EmailExistsException;
import com.example.shop_web.service.jwt.JwtService;
import com.example.shop_web.service.role.IRoleService;
import com.example.shop_web.service.user.IUserService;
import com.example.shop_web.util.AuthUtil;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthAPI {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private AuthUtil authUtil;


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterReqDTO userRegisterReqDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return authUtil.mapErrorToResponse(bindingResult);

        Boolean existsByUsername = userService.existsByUsername(userRegisterReqDTO.getUsername());

        if (existsByUsername) {
            throw new EmailExistsException("Account already exists");
        }

        Optional<Role> optRole = roleService.findById(userRegisterReqDTO.getRoleId());

        if (!optRole.isPresent()) {
            throw new DataInputException("Invalid account role");
        }
        String pw = userRegisterReqDTO.getPassword();
        String rePw = userRegisterReqDTO.getRePassword();

        if (!Objects.equals(pw, rePw)) {
            throw new DataInputException("Xác nhận lại mật khẩu");
        }


        try {
            userService.save(userRegisterReqDTO.toUser(optRole.get()));

            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Account information is not valid, please check the information again");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtService.generateTokenLogin(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User currentUser = userService.getByUsername(user.getUsername());

            JwtResponse jwtResponse = new JwtResponse(
                    jwt,
                    currentUser.getId(),
                    userDetails.getUsername(),
                    currentUser.getUsername(),
                    userDetails.getAuthorities()
            );

            ResponseCookie springCookie = ResponseCookie.from("JWT", jwt)
                    .httpOnly(false)
                    .secure(false)
                    .path("/")
                    .maxAge(1000L * 60 * 60 * 24 * 30)
                    .domain("localhost")
                    .build();

            System.out.println(jwtResponse);

            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.SET_COOKIE, springCookie.toString())
                    .body(jwtResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}

