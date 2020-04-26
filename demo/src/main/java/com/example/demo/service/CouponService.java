package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.CouponDao;
import com.example.demo.domain.Coupon;

@Service
public class CouponService {
	
	@Autowired
	private CouponDao couponDao;
	
	@Autowired
    private RestTemplate restTemplate;
 
	private final int LIMIT = 1000;
	
//	public static void main(String[] args) {
//		UUID uuid = UUID.randomUUID();
//		String couponCode = uuid.toString();
//		System.err.println(couponCode);
//	}
	
	public CouponService(RestTemplateBuilder restTemplateBuilder) { 
		this.restTemplate = restTemplateBuilder.build(); 
	}

	
	public Coupon getCoupon(String id) {
		Coupon coupon = restTemplate.getForObject("http://localhost:8080/coupon/" + id, Coupon.class);
		return coupon;
	}
	

	public void makeCoupons(Integer N) {
		
		
		List<Coupon> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (N == 1) {
			
			UUID uuid = UUID.randomUUID();
			String couponCode = uuid.toString();
			
			Coupon coupon = new Coupon();
			coupon.setCouponCode(couponCode);
			insert(coupon);
			
		} else if (N > LIMIT) {
			
			int count = N/LIMIT+1;
			int remain = LIMIT;
			
			for (int i=0; i<count; i++) {
				if (i == count-1) {
					remain = N%LIMIT;
				}
				list = new ArrayList<Coupon>();
				makeCoupon(list, remain);
				map.put("list", list);
				insertBatch(map);
			}
			
			
		} else {
			list = new ArrayList<Coupon>();
			makeCoupon(list, N);
			map.put("list", list);
			insertBatch(map);
		}
		
	}

	private void makeCoupon(List<Coupon> list, int remain) {
		UUID uuid = null;
		String couponCode = "";
		Coupon coupon = null;
		while (remain > 0)  {
			uuid = UUID.randomUUID();
			couponCode = uuid.toString();
			//System.out.println(remain + ":" + couponCode);
			
			coupon = new Coupon();
			coupon.setCouponCode(couponCode);
			list.add(coupon);
			
			remain--;
		}
	}
	
	@Transactional
	public String select(String useYn, String giveYn) {
		Coupon coupon = couponDao.select(useYn, giveYn);
		String couponCode = coupon.getCouponCode();
		System.err.println("coupon" + coupon);
		
		// 후처리
		if (!couponCode.isEmpty()) {
			coupon.setGiveYn("Y");
			update(coupon);
		}
		return couponCode;
	}
	
	public List<Coupon> selectList(String giveYn, String expireDate, String expireYn) {
		return couponDao.selectList(giveYn, expireDate, expireYn);
	} 
	
	public void insertBatch(Map<String, Object> map) {
		couponDao.insertBatch(map);
	}

	public int insert(Coupon coupon) {
		return couponDao.insert(coupon);
	}
	
	public int update(Coupon coupon) {
		return couponDao.update(coupon);
	}

}
