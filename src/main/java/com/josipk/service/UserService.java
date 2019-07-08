package com.josipk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import org.springframework.stereotype.Service;

import com.josipk.entity.User;
import com.josipk.repository.UserRepo;

@Service
public class UserService {
	
	 @Autowired
	 private UserRepo userRepository;
	 
//	 @Autowired
//	 private PasswordEncoder passwordEncoder;
	 
	 @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
     }

	 public void save(User user){
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		 //user.setPassword(user.getPassword());
	 	userRepository.save(user);
	 }

	 public User getUser(String username){
	     return userRepository.findByUsername(username);
	 }

	 public List<User> getAllUsers() {
	      return userRepository.findAll();
	 }

}
