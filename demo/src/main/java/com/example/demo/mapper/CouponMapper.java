package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Coupon;

@Repository
public interface CouponMapper {
	
	// 사용여부 넣어야되나? 무조건 사용안한거 조회할텐데  
	Coupon select();
	// 사용여부, 만료여부, 지급여부, 사용자 아이디 다 넣어야
	// 만료날짜
	List<Coupon> selectList();

	int insert();
	
	int update();
	
	int delete();
	
	
}
