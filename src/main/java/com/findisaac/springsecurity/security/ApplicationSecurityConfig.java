package com.findisaac.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Configuration class for spring security.
 * This class would allow us to override custom settings for spring security
 * within our application.
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * This Class allows us to customize the http security class.
     * @param http HttpSecurity class instance
     * @throws Exception Exception thrown by spring security
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Authorize requests
                .authorizeRequests()
                // Whitelist endpoints
                .antMatchers("/", "/index", "/js/*", "/css/*")
                // Permit all whitelisted values
                .permitAll()
                // Applies to all requests
                .anyRequest()
                // Check that the request is authenticated
                .authenticated()
                .and()
                // Specify that basic auth should be used
                .httpBasic();
    }

    /**
     * UserDetailsService class instance
     * @return In memory user details
     */
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        // A user login details are manually entered into the application at
        // compile time.
        UserDetails jamesBondUser = User.builder()
                .username("jamesbond")
                .password("jamesbond")
                .roles("STUDENT") // Spring would save it as "ROLE_STUDENT"
                .build();
        // Return the InMemory user details for the created users
        return new InMemoryUserDetailsManager(
                jamesBondUser
        );
    }
}
