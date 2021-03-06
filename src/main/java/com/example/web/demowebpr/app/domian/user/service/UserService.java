package com.example.web.demowebpr.app.domian.user.service;


import com.example.web.demowebpr.app.dao.UserRepository;
import com.example.web.demowebpr.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(username);
        if (user != null){
            return user;
        }
        throw new UsernameNotFoundException("User \"" + username + "\" not found");
    }


}
