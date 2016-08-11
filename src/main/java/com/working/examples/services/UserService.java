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
		userRepository.save(user);
	}
	
	public void deleteUser(Long id){
		userRepository.delete(id);;
	}
	
	public User findUser(Long id){
		return userRepository.findOne(id);
	}
	
	public void updateUser(User user){
		userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
			return userRepository.findAll();
	}
	
}
