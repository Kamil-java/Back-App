package com.example.web.demowebpr.dao;

import com.example.web.demowebpr.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
