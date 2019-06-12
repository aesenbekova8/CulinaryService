package com.example.CulinaryService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecureConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/getAll").permitAll()
//                .antMatchers("/user/delete/{id}").access("hasRole('ADMIN')")
//                .antMatchers("/user/get/{id}").access("hasRole('USER')")
//                .antMatchers("/user/toOrder/{userId}/{cookId}").access("hasRole('USER')")
//                .antMatchers("/user/getAllOrders").access("hasRole('USER')")
//                .antMatchers("/cook/add").access("hasRole('USER')")
//                .antMatchers("/cook/getAll").access("hasRole('USER')")
//                .antMatchers("/cook/get/{id}").access("hasRole('USER')")
//                .antMatchers("/cook/delete/{id}").access("hasRole('ADMIN')")
                .antMatchers("/register").permitAll()
                .antMatchers("/asCook/{userId}").permitAll()
//                .antMatchers("/roles/add").access("hasRole('ADMIN')")
                .and().httpBasic()
                .and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .dataSource(dataSource)
                .usersByUsernameQuery("select active, email, last_name, name, password, " +
                        "phone_no from users where email = ?")
                .authoritiesByUsernameQuery("select u.email, r.role from users u inner join user_role ur on(u.id=ur.users_id)" +
                        "inner join roles r on(ur.roles_id=r.id) where u.email = ?;");

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}user123").roles("USER")
//                .and().withUser("admin").password("{noop}admin123").roles("ADMIN");
//    }

//        @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
