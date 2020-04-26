package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/make")
	public String makeCounpons(@RequestParam(required = true) Integer N) {
		String returnMessage = "makeCounpons";

		couponService.makeCoupons(N);
		
		return returnMessage;
	}

	/**
	 * 쿠폰 하나 지급
	 * output : 쿠폰 번호  
	 */
	@GetMapping("/get")
	public String getCounponCode() {
		String couponCode = couponService.select("N","N");
		System.err.println(couponCode);
		return couponCode;
	}
	
	/**
	 * 지급된 쿠폰 리스트 조회
	 * output : 쿠폰 리스트  
	 */
	@GetMapping("/get/list")
	public List<Coupon> getCouponList() {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
		Date date = new Date();
		String todayDate = format.format(date);
		List<Coupon> list = couponService.selectList("Y", todayDate, "N");
		return list;
	}
	
	/**
	 * 지급된 쿠폰 하나 사용
	 * input : 쿠폰 번호  
	 */
	@PutMapping("/use")
	public String usedCoupon(@RequestParam(required = true) String couponCode) {
		String returnMessage = "usedCoupon";
		Coupon coupon = new Coupon();
		coupon.setCouponCode(couponCode);
		coupon.setUseYn("Y");
		couponService.update(coupon);
		return returnMessage;
	}
	
	/**
	 * 쿠폰 사용 취소
	 * input : 쿠폰 번호  
	 */
	@PutMapping("/use/cancel")
	public String cancelUseCoupon(@RequestParam(required = true) String couponCode) {
		String returnMessage = "";
		Coupon coupon = new Coupon();
		coupon.setCouponCode(couponCode);
		coupon.setUseYn("N");
		couponService.update(coupon);
		return returnMessage;
	}

	/**
	 * 당일 만료된 쿠폰 리스트 조회
	 * output : 쿠폰 리스트  
	 */
	@GetMapping("expire/list/today")
	public List<Coupon> expireCouponListToday() {
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		Date date = new Date();
		String todayDate = format.format(date);
		List<Coupon> list = couponService.selectList(null, todayDate, "Y");
		return list;
	}
}
