package com.example.demo.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public int insert(User user) {
		String encodedPassword = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
		user.setUserPassword(encodedPassword);
		return userDao.insert(user);
	}
	
	public User login(String id, String password) {
		String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		return userDao.select(id, encodedPassword);
	}

}
