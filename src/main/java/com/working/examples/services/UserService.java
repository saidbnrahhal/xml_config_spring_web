package com.working.examples.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.examples.models.User;
import com.working.examples.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user){
		userRepository.addUser(user);
	}
	
	public void deleteUser(Long id){
		userRepository.deleteUser(id);
	}
	
	public User findUser(Long id){
		return userRepository.findUser(id);
	}
	
	public void updateUser(User user){
		userRepository.addUser(user);
	}
	
	public List<User> getAllUsers(){
			return userRepository.getAllUsers();
	}
	
}
