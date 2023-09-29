package com.lamell.padelkarin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception{
        http

                .authorizeHttpRequests((authorize) ->  authorize
                        .requestMatchers("/static/**", "/signup", "/about").permitAll()
                        .requestMatchers("api/v5/availability").hasAnyRole("USER","ADMIN")
                        .requestMatchers("api/v5/bookings").hasRole("USER")
                        .requestMatchers("api/v5/mybookings/{id}").hasRole("USER")
                        .requestMatchers("api/v5/infotext").permitAll()
                        .requestMatchers("api/v5/courts").hasAnyRole("USER","ADMIN")
                        .requestMatchers("api/v5/customers").hasRole("ADMIN")
                        .requestMatchers("api/v5/register").hasRole("ADMIN")
                        .requestMatchers("api/v5/deletebooking/{id}").hasRole("ADMIN")
                        .requestMatchers("api/v5/allbookings").hasRole("ADMIN")
                        .requestMatchers("api/v5/deletecourt/{id}").hasRole("ADMIN")
                        .requestMatchers("api/v5/deleteinfo/{id}").hasRole("ADMIN")
                        .requestMatchers("api/v5/bookings/{id}").hasRole("ADMIN")
                        .requestMatchers("api/v5/updateinfo").hasRole("ADMIN")
                        .requestMatchers("api/v5/updateinfotext").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        ).csrf().disable().httpBasic();

        return http.build();
    }


}
