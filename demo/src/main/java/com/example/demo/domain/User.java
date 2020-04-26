package com.example.demo.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2731598327208972274L;

	String userId;
	
	String userPassword;
}
