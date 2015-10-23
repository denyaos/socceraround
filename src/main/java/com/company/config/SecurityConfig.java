package com.company.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                    .withUser("user1").password("pass").roles("ADMIN")
                .and()
                    .withUser("user2").password("pass").roles("ADMIN");

    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/console/**").permitAll().and()
                .authorizeRequests()
                .anyRequest().authenticated().and()
                .formLogin().defaultSuccessUrl("/user").and()
                .logout().permitAll().and()
                .csrf().disable();
        http
                .csrf().disable();
        http
                .headers().frameOptions().disable();
    }

}
