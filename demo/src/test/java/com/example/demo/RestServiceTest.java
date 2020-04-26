package com.example.demo;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.CouponDao;
import com.example.demo.domain.Coupon;
import com.example.demo.service.CouponService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@RestClientTest(CouponService.class)
public class RestServiceTest {

	@Autowired
    private CouponService couponService;
	
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private CouponDao couponDao;
 
    private MockRestServiceServer mockServer;
    
    private ObjectMapper mapper = new ObjectMapper();
 
    @Before
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void test() throws URISyntaxException {
    	Coupon coupon = new Coupon();
    	String couponCode = UUID.randomUUID().toString();
    	coupon.setCouponCode(couponCode);
    	
    	mockServer.expect(ExpectedCount.once(),
    			requestTo(new URI("http://localhost:8080/coupon/test")))
    			.andExpect(method(HttpMethod.GET))
    			.andRespond(withStatus(HttpStatus.OK)
    			//.contentType(MediaType.APPLICATION_JSON)
    			//.body(mapper.writeValueAsString(null))
    			);
    	
    	Object obj = couponService.getCoupon("test");
    	mockServer.verify();
    	//assertEquals("test", obj);
    	then("test").isEqualTo(obj.toString());

    }
}
