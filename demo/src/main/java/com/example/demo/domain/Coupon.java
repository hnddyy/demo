package com.example.demo.domain;

import java.io.Serializable;

public class Coupon	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7845431428550164927L;
	
	String couponCode;
	
	String useYn;
	
	String expireYn;
	
	String giveYn;
	
	String userId;
	
	//생성일
	//만료일
	//만료 3일전 알림여부
	

}
