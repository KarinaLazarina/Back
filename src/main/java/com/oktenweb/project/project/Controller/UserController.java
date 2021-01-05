package com.oktenweb.project.project.Controller;

import com.oktenweb.project.project.Entity.User;
import com.oktenweb.project.project.Service.IUserService;
import com.oktenweb.project.project.Validator.PasswordValidator;
import com.oktenweb.project.project.Validator.UniqueUserEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    private IUserService userService;
    private PasswordValidator passwordValidator;
    private UniqueUserEmailValidator uniqueUserEmailValidator;

    public UserController(IUserService userService, PasswordValidator passwordValidator, UniqueUserEmailValidator uniqueUserEmailValidator) {
        this.userService = userService;
        this.passwordValidator = passwordValidator;
        this.uniqueUserEmailValidator = uniqueUserEmailValidator;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody @Valid User user){
        System.out.println(user);
        return userService.singUpUser(user);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(passwordValidator, uniqueUserEmailValidator);
    }
}
