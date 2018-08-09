package com.mybank.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.model.User;
import com.mybank.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@GetMapping(produces="application/json")
	public List<User> getUsers(){
		System.out.println("test");
		List<User> userList = userService.getUsers();
		return userList;
		
	}
	
	@GetMapping(path="/{id}",produces="application/json")
	public User getUser(@PathVariable int id){
		System.out.println("test"+id);
		User user = userService.getUser(id);
		return user;
		
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User user) {
	    System.out.println("user  "+user.name);
	    return userService.addUser(user);
	}
	
	

}
