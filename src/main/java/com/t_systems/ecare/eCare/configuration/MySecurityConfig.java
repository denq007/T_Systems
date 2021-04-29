
package com.t_systems.ecare.eCare.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@ComponentScan(basePackages = "com.t_systems.ecare.eCare")
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select login,password,blocked from user where login=?")
                .authoritiesByUsernameQuery("select u.login,ur.roles from user u inner join user_role ur on u.customer_id=ur.customer_id where u.login=?");
    }
   //https://spring.io/guides/gs/securing-web/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/registration","/showallcustomer","/saveCustomer","/user/**","/customer/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}

