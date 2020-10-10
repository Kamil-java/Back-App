package com.example.web.demowebpr.app.dao;

import com.example.web.demowebpr.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
