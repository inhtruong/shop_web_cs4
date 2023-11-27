package com.example.shop_web.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BranchCreReqDTO implements Validator {
    private String branchName;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
