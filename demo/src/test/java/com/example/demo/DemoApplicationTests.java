package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.CouponService;

@RunWith(SpringRunner.class)
class DemoApplicationTests {
	
	@Autowired
	private CouponService couponService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void executeBatch() {
		long startTime = System.currentTimeMillis();	
		couponService.makeCoupons(1);
		long endTime = System.currentTimeMillis();	
		long resutTime = endTime - startTime;
		String batchTypeDesc = "[foreach batch]";
		System.out.println(batchTypeDesc + " 소요시간  : " + resutTime/1000 + "(ms)");
	}

	@Test
	public void executeBatch2() {
		long startTime = System.currentTimeMillis();	
		couponService.makeCoupons(1000);
		long endTime = System.currentTimeMillis();	
		long resutTime = endTime - startTime;
		String batchTypeDesc = "[foreach batch]";
		System.out.println(batchTypeDesc + " 소요시간  : " + resutTime/1000 + "(ms)");
	}
	
	@Test
	public void executeBatch3() {
		long startTime = System.currentTimeMillis();	
		couponService.makeCoupons(100000);
		long endTime = System.currentTimeMillis();	
		long resutTime = endTime - startTime;
		String batchTypeDesc = "[foreach batch]";
		System.out.println(batchTypeDesc + " 소요시간  : " + resutTime/1000 + "(ms)");
	}

}
