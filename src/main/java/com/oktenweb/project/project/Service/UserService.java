package com.oktenweb.project.project.Service;

import com.oktenweb.project.project.DAO.UserDAO;
import com.oktenweb.project.project.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public User singUpUser(User user) {
        return userDAO.save(user);
    }
}
