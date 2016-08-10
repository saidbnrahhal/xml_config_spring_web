package com.working.examples.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.working.examples.models.User;

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addUser(User user){
		entityManager.persist(user);
		entityManager.flush();
	}
	
	public void deleteUser(Long id){
		User user =entityManager.find(User.class, id);
		entityManager.remove(user);
	}
	
	public User findUser(Long id){
		return entityManager.find(User.class, id);
	}
	
	public void updateUser(User user){
		entityManager.merge(user);
	}
	
	public List<User> getAllUsers(){
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}
}
