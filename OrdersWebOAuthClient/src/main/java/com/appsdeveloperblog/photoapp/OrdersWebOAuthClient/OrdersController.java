/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.photoapp.OrdersWebOAuthClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrdersController {
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/token")
	public String getToken(
			//@RegisteredOAuth2AuthorizedClient("users-client-oidc") OAuth2AuthorizedClient authorizedClient) {
			@RegisteredOAuth2AuthorizedClient("keycloak") OAuth2AuthorizedClient authorizedClient) {
		
		
		String jwtAccessToken = authorizedClient.getAccessToken().getTokenValue();
				System.out.println("jwtAccessToken =  " + jwtAccessToken);
		

		return jwtAccessToken;
		

	}
	
	
}
