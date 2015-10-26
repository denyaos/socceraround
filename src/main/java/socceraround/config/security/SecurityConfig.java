package socceraround.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired UserDetailsService userDetailsService;
    @Autowired AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired AuthenticationSuccessHandler successHandler;
    @Autowired AuthenticationFailureHandler failureHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/scripts/**", "/styles/**", "/images/**", "/favicon.ico").permitAll()
                .antMatchers("/register").anonymous()
                .antMatchers("/console/**").permitAll()
                .anyRequest().authenticated()
        .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
        .and()
                .formLogin()
                .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .permitAll()
        .and()
                .logout()
                .permitAll()
        .and()
                .csrf().disable();
        http
                .csrf().disable();
        http
                .headers().frameOptions().disable();
    }
}
