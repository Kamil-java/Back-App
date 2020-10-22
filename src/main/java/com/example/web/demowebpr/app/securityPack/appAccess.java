package com.example.web.demowebpr.app.securityPack;

import com.example.web.demowebpr.app.domian.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
public class appAccess extends WebSecurityConfigurerAdapter {
    private final UserService userService;

    @Autowired
    public appAccess(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder encoder(){
        return new StandardPasswordEncoder("pass");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(encoder());
    }

        @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/covidReport").hasAnyRole("USER")
                .and()
                .csrf().disable();
    }
}
