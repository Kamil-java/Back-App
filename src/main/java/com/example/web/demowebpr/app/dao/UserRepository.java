package com.example.web.demowebpr.app.dao;

import com.example.web.demowebpr.app.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByName(String name);
}
