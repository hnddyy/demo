package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;
    
    @ApiOperation(value ="로그인")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "로그인 사용자 ID", required = true, dataType = "String", paramType = "query", defaultValue = ""),
		@ApiImplicitParam(name = "userPassword", value = "사용자 패스워드", required = true, dataType = "String", paramType = "query", defaultValue = "") 
		})
    @PostMapping("/signin")
    public String signin(String userId, String userPassword, HttpServletResponse response){
    	User user = userService.login(userId, userPassword);
    	
    	if (user == null) {
    		return "login fail";
    	}
    	
        String token = jwtService.create("login", user, "user");
        log.debug("token :" + token);
        response.setHeader("Authorization", token);
        return "login success";
    }
    
    @ApiOperation(value ="회원가입")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "사용자 ID", required = true, dataType = "String", paramType = "query", defaultValue = ""),
		@ApiImplicitParam(name = "userPassword", value = "사용자 패스워드", required = true, dataType = "String", paramType = "query", defaultValue = "") 
		})
    @PostMapping("/signup")
    public String signup(@RequestBody User user){
    	try {
    		userService.insert(user);
    	} catch (Exception e) {
    		return "signup fail";
    	}
        
        return "signup success";
    }
    

}
