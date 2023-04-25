package com.example.demo.securirty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;


@EnableMethodSecurity(securedEnabled = true,prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class WebSecurity  {

	@Bean
	public JwtDecoder jwtDecoder() {
	    return NimbusJwtDecoder.withJwkSetUri("http://localhost:8180/realms/poc/protocol/openid-connect/certs").build();
	}
	 @Bean
	// @Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	     		 
		 JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
			jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());
		 http 
		 .authorizeHttpRequests().
		 requestMatchers(HttpMethod.GET,"/users/status/check").
		 //hasAuthority("SCOPE_profile")
		 hasRole("developer")
		// hasAuthority("ROLE_developer")		 
		 .anyRequest().	
		 authenticated().and().oauth2ResourceServer().jwt()
		 .jwtAuthenticationConverter(jwtAuthenticationConverter);
		 
		 
		 return http.build();
	    }
}
