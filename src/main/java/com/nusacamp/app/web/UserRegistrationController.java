package com.nusacamp.app.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nusacamp.app.model.User;
import com.nusacamp.app.service.UserService;
import com.nusacamp.app.web.dto.UserRegistrationDto;
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	private UserService userservice;
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationModel(Model model) {
		return "registration";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user")@Valid UserRegistrationDto userDto, BindingResult result) {
		User existing = userservice.findByEmail(userDto.getMail());
		if(existing != null) {
			result.rejectValue("mail",null, "email already registered");
		}if(result.hasErrors()) {
			return "registration";
		}
		userservice.save(userDto);
		return "redirect:/registration?sucess";
	}

}
