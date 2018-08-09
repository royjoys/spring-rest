package com.mybank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.dao.UserDao;
import com.mybank.model.User;


@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<User> getUsers(){
		return userDao.getUsers();
	}
	
	public User getUser(int id) {
		return userDao.getUser(id);
	}
	
	public User addUser(User user) {
		return userDao.addUser(user);
	}
}
