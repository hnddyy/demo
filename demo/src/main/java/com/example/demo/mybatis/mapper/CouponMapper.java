package com.example.demo.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.Coupon;

@Mapper
public interface CouponMapper {
	
	Coupon select(@Param("useYn") String useYn
				,@Param("giveYn") String giveYn);

	List<Coupon> selectList(@Param("giveYn") String giveYn
						,@Param("expireDate") String expireDate
						,@Param("expireYn") String expireYn);

	int insert(Coupon coupon);
	
	int insertBatch(Map<String, Object> map);
	
	int update(Coupon coupon);
	
}
