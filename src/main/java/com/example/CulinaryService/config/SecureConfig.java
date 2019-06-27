package com.example.CulinaryService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecureConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/getAll").access("hasRole('ADMIN')")
                .antMatchers("/user/getById/{id}").access("hasRole('ADMIN')")
                .antMatchers("/user/delete/{id}").access("hasRole('ADMIN')")
                .antMatchers("/user/get/{name}").permitAll()
                .antMatchers("/user/{cookId}/add").access("hasRole('USER')")
                .antMatchers("/user/favorites").access("hasRole('USER')")

                .antMatchers("/skill/add").access("hasRole('ADMIN')")

                .antMatchers("/role/add").access("hasRole('ADMIN')")

                .antMatchers("/register").permitAll()
                .antMatchers("/asCook").access("hasRole('USER')")

                .antMatchers("/order/getAllOrders").access("hasRole('USER')")
                .antMatchers("/order/toOrder/{cookId}").access("hasRole('USER')")

                .antMatchers("/message/send/{toUserId}").permitAll()

                .antMatchers("/cook/getAll").permitAll()
                .antMatchers("/cook/get/{id}").access("hasRole('ADMIN')")
                .antMatchers("/cook/delete/{id}").access("hasRole('ADMIN')")
                .antMatchers("/cook/getByCategory").permitAll()
                .antMatchers("/cook/getAllCooks").permitAll()
                .antMatchers("/cook/rateCook/{cookId}").access("hasRole('USER')")

                .antMatchers("/chat/getAll").access("hasRole('USER')")
                .antMatchers("/chat/{toUserId}/send").permitAll()

                .antMatchers("/app/{cookId}/app").access("hasRole('USER')")
                .antMatchers("/app/{appId}/confirm").access("hasRole('COOK')")
                .antMatchers("/app/getAll").access("hasRole('COOK')")
                .antMatchers("/app/getAllConfirmApp").access("hasRole('COOK')")
                .and().httpBasic()
                .and().csrf().disable();
    }
}
