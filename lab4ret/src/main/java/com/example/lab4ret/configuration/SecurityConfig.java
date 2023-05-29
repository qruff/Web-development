package com.example.lab4ret.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //
                .antMatchers("/doctors/newdoctor").hasRole("ADMIN")
                .antMatchers("/doctors/newpatient").hasRole("ADMIN")
                .antMatchers("/doctors/del/**").hasRole("ADMIN")
                .antMatchers("/doctors/edit").hasRole("ADMIN")
                .antMatchers("/doctors/edit/**").hasRole("ADMIN")
                .antMatchers("/doctors/del").hasRole("ADMIN")//  ADMIN /admin/**
                .antMatchers("/doctors/patient").hasAnyRole("USER", "ADMIN")
                .antMatchers("/doctors/patient/**").hasAnyRole( "ADMIN")
                .antMatchers("/doctors/priem/**").hasAnyRole( "ADMIN")
                .antMatchers("/doctors/priem").hasAnyRole( "ADMIN")
                .antMatchers("/doctors/priems").hasAnyRole("USER","ADMIN")
                .antMatchers("/doctors/priems/**").hasRole("ADMIN")
                .and()
                .formLogin() //
                .loginPage("/doctors")
                .defaultSuccessUrl("/doctors")
                .permitAll()
                .loginProcessingUrl("/authenticateTheUser")
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll();
    }
}
