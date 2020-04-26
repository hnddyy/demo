package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;
import com.example.demo.mybatis.mapper.UserMapper;

@Repository
public class UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public int insert(User user) {
		return userMapper.insert(user); 
	}
	
	public User select(String id, String password) {
		return userMapper.select(id, password);
	}

}
