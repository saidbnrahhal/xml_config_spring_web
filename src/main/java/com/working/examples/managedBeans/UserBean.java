package com.working.examples.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.working.examples.models.User;
import com.working.examples.services.UserService;

@Component
@ManagedBean(name="userBean")
@SessionScoped
public class UserBean {

	private static final Logger LOGGER =LoggerFactory.getLogger(UserBean.class);
	@Autowired
	UserService userService ;
	
	private Long id ;
	private String firstName;
	private String lastName;
	private String email;
	private String password ;
	


	public List<User> getUserList(){
		List<User> users = new ArrayList<User>();
		LOGGER.error("retrieving all users.");
		users =userService.getAllUsers();
		return users;
	};
	
	public void addUser(){
		User user =new User();
		user.setFirstName(getFirstName());
		user.setEmail(getEmail());
		user.setLastName(getLastName());
		user.setPassword(getPassword());
 		userService.addUser(user);
		LOGGER.error("adding a new user : "+user.toString());

	};
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
