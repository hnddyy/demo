package com.example.demo;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.CouponDao;
import com.example.demo.domain.Coupon;

@RunWith(SpringRunner.class)
public class DaoTest {
	
	@Autowired
	private CouponDao couponDao;
	
	@Test
	@Order(1)
	public void insert() {
//		String couponCode = "1e842a90-1bf3-4d1f-9cb3-1ad3c6c182a1";
//		Coupon coupon = new Coupon();
//		coupon.setCouponCode(couponCode);
//		int count = couponDao.insert(coupon);
//		assertEquals(1, count);
//		coupon = couponDao.select("N", "N");
//		then(couponCode).isEqualTo(coupon.getCouponCode());
	}
	
	@Test
	public void selectOne() {
		String couponCode = "1e842a90-1bf3-4d1f-9cb3-1ad3c6c182a1";
		Coupon coupon = couponDao.select("N", "N");
		then(couponCode).isEqualTo(coupon.getCouponCode());
	}

}
