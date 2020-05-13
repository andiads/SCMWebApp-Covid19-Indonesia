package com.nusacamp.app.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nusacamp.app.model.User;
import com.nusacamp.app.model.UserType;
import com.nusacamp.app.repository.UserRepository;
import com.nusacamp.app.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public User findByEmail(String mail) {
		
		return userRepository.findByMail(mail);
	}
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException{
		User user = userRepository.findByMail(mail);
		if(user == null) {
			throw new UsernameNotFoundException("invalid Username or password");	
		}
		return new org.springframework.security.core.userdetails.User(user.getMail()
				,user.getPassword(),
				mapUserTypesToAuthorities(user.getUserTypes()));
				
		
	}
	
	@Override
	public User save(UserRegistrationDto registration) {
		User user = new User();
		user.setMail(registration.getMail());
		user.setFullName(registration.getFullName());
		user.setPassword(passwordEncoder.encode(registration.getPassword()));
		user.setUserTypes(Arrays.asList(new UserType("USER_ROLE")));
		
		return userRepository.save(user);
	
	}
	
	private Collection<? extends GrantedAuthority> mapUserTypesToAuthorities(Collection<UserType> userTypes){
		return userTypes.stream()
				.map(userType -> new SimpleGrantedAuthority(userType.getType_name()))
				.collect(Collectors.toList());
		
	}
	
}
