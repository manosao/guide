package gr.manos.guide.restapi.controllers;

import javax.validation.Valid;

import gr.manos.guide.restapi.models.User;
import gr.manos.guide.restapi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/security")
public class SecurityController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping(value="/register")
	public User registerUser(@Valid @RequestBody User newUser) {
		return userRepository.save(User.builder()
				.username(newUser.getUsername())
				.password(passwordEncoder.encode(newUser.getPassword()))
				.build());
	}
	
	@PostMapping(value="/token")
	public String getJwtToken(@RequestBody User credentials) {
		String ans = "manos";
		return ans;
	}
	
	
	
}
