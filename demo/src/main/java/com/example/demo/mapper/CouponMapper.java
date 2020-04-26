package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.Coupon;

@Mapper
public interface CouponMapper {
	
	// 사용여부 넣어야되나? 무조건 사용안한거 조회할텐데  
	Coupon select(@Param("useYn") String useYn
				,@Param("giveYn") String giveYn);
	// 사용여부, 만료여부, 지급여부, 사용자 아이디 다 넣어야
	// 만료날짜 3일전이랑 오늘꺼 조회  
	List<Coupon> selectList(@Param("giveYn") String giveYn
						,@Param("expireDate") String expireDate);

	int insert(Coupon coupon);
	
	int update(Coupon coupon);
	
}
