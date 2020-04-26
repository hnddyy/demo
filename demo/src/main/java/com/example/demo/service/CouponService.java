package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CouponDao;

@Service
public class CouponService {
	
	@Autowired
	private CouponDao couponDao;
	
    
	

}
