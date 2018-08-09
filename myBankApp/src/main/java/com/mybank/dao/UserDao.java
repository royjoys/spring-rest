package com.mybank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mybank.model.User;


@Component
public class UserDao {
	
	@Autowired
	SessionFactory sessionFactory;


	
	@Transactional
	public List<User> getUsers(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}
	
	@Transactional
	public User addUser(User user){
		Session session = sessionFactory.getCurrentSession();
		//session.saveOrUpdate(user);
		session.save(user);
		return new User();
	}

	@Transactional
	public User getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, new Integer(id));
		return user;
	}

	
	
}
