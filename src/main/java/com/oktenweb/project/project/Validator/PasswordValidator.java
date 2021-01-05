package com.oktenweb.project.project.Validator;

import com.oktenweb.project.project.Entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import java.util.regex.Pattern;

@Component
public class PasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(@Valid Object o, Errors errors) {
        User user = (User) o;
        String regex = "^(?!.* )(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*[@$!%*#?&]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        if (user.getPassword() != null && user.getPassword().length()>0){
            if (!pattern.matcher(user.getPassword()).matches()){
                errors.rejectValue("password","user.password","Password is weak!!!");
            }
        }
    }
}
