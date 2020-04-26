package com.example.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.User;

@Mapper
public interface UserMapper {
	
	int insert(User user);
	
	User select(@Param("userId") String userId, @Param("password") String password);

}
