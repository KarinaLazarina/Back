package com.oktenweb.project.project.DAO;

import com.oktenweb.project.project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
