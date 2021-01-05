package com.oktenweb.project.project.Validator;

import com.oktenweb.project.project.DAO.UserDAO;
import com.oktenweb.project.project.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;

@Component
public class UniqueUserEmailValidator implements Validator {
    private final UserDAO userDAO;

    @Autowired
    public UniqueUserEmailValidator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(@Valid Object o, Errors errors) {
        User user = (User) o;
        if (user.getEmail() != null && user.getEmail().trim().length() > 0){
            if (userDAO.existsByEmail(user.getEmail())){
                errors.rejectValue("email","user.email.unique", "Email must be unique!!!");
            }
        }
    }
}
