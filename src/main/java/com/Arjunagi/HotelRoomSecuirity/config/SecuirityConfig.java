package com.Arjunagi.HotelRoomSecuirity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecuirityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserNameToUserDetails();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     //   return http.authorizeHttpRequests(auth->auth.requestMatchers("/rooms").hasRole("ADMIN").requestMatchers("/").authenticated()).formLogin(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable).build()
        return http.authorizeHttpRequests(auth->auth.requestMatchers("/admin/**").hasRole("ADMIN").requestMatchers("/","/user/register").permitAll().requestMatchers("/room/**").authenticated()).formLogin(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable).build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }

}
