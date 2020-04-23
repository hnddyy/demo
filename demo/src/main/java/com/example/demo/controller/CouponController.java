package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Coupon;
import com.example.demo.service.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	/**
	 * N개 쿠폰 발급
	 * input : N
	 */
	@PostMapping("/make")
	public String makeCounpons(@RequestParam(required = true) Integer N) {
		String returnMessage = "";
		return returnMessage;
	}
	
	/**
	 * 쿠폰 하나 지급
	 * output : 쿠폰 번호  
	 */
	@GetMapping("/get")
	public String getCounponCode() {
		String couponCode = "";
		return couponCode;
	}
	
	/**
	 * 지급된 쿠폰 리스트 조회
	 * output : 쿠폰 리스트  
	 */
	@GetMapping("/get/list")
	public List<Coupon> getCouponList() {
		return null;
	}
	
	/**
	 * 지급된 쿠폰 하나 사용
	 * input : 쿠폰 번호  
	 */
	@PutMapping("/use")
	public String usedCoupon(@RequestParam(required = true) String couponCode) {
		String returnMessage = "";
		return returnMessage;
	}
	
	/**
	 * 쿠폰 사용 취소
	 * input : 쿠폰 번호  
	 */
	@PutMapping("/use/cancel")
	public String cancelUseCoupon(@RequestParam(required = true) String couponCode) {
		String returnMessage = "";
		return returnMessage;
	}

	/**
	 * 당일 만료된 쿠폰 리스트 조회
	 * output : 쿠폰 리스트  
	 */
	@GetMapping("expire/list/today")
	public List<Coupon> expireCouponListToday() {
		return null;
	}
}
