package com.example.demo.Auth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.core.annotation.Order;
@Configuration
public class AuthorizationServerConfig {
/*
    @Bean
    public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception {

        // Apply default OAuth security
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);

        // Disable CSRF (important for APIs)
             http
                .csrf(csrf -> csrf.disable()).formLogin(Customizer.withDefaults());
               return http.build();
    }
    
       enable defalut login page 
	
	
	


	@Bean
	@Order(1)
	public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception {
	    OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
	    return http.build();
	}

	@Bean
	@Order(2)
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
	        .formLogin(Customizer.withDefaults());
	    return http.build();
	}
	
	*/
	
	
	// 🔐 OAuth2 Authorization Server (HIGH PRIORITY)
    @Bean
    @Order(1)
    public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception {
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
        return http.build();
    }

    // 🌐 Application Security (LOW PRIORITY)
    @Bean
    @Order(2)
    public SecurityFilterChain appSecurityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/register").permitAll()   // ✅ ALLOW REGISTER
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(Customizer.withDefaults()); // OAuth needs login page

        return http.build();
    }
	
	
	
	
	
	
	
}


