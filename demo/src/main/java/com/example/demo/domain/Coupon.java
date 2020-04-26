package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("coupon")
public class Coupon	implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7845431428550164927L;
	
	String couponCode;
	
	String useYn;
	
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
