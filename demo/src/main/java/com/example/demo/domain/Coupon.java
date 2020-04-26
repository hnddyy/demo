package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Coupon	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7845431428550164927L;
	
	String couponCode;
	
	String useYn;
	
	//String expireYn; 이거 넣으면 스케줄링에서 처리해야
	
	// 지급 여부
	String giveYn;
	
	// 소유 
	String userId;
	
	//생성일
	Date makeDate;
	
	// 만료일
	String expireDate;
	
	// 만료 3일전 알림여부
	String expireAlarmYn;

}
