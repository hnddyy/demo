package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Coupon;
import com.example.demo.mybatis.mapper.CouponMapper;

@Repository
public class CouponDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private CouponMapper couponMapper;
	
	public Coupon select(String useYn, String giveYn) {
		return couponMapper.select(useYn, giveYn);
	}
	
	public List<Coupon> selectList(String giveYn, String expireDate, String expireYn) {
		return couponMapper.selectList(giveYn, expireDate, expireYn);
	}
	
	@Transactional
	public void insertBatch(Map<String, Object> map) {
		
//	    long startTime = System.currentTimeMillis();
		
	    sqlSession.update("com.example.demo.mybatis.mapper.CouponMapper.insertBatch", map);
	    
//		long endTime = System.currentTimeMillis();
//        long resutTime = endTime - startTime;
//        System.out.println("트랜젝션 배치" + " 소요시간  : " + resutTime/1000 + "(ms)");
	}

	public int insert(Coupon coupon) {
		return couponMapper.insert(coupon);
	}
	
	public int update(Coupon coupon) {
		return couponMapper.update(coupon);
	}
	
}
