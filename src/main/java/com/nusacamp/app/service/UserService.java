package com.nusacamp.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nusacamp.app.model.User;
import com.nusacamp.app.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
	User findByEmail(String mail);

	User save(UserRegistrationDto registration);

}
