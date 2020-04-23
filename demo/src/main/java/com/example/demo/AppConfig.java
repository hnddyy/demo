package com.example.demo;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(
	    basePackages = "com.example.demo", 
	    excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Controller.class)
	)
public class AppConfig {

	 /**
     * RestTemplate 은 기본적으로 pooling 하지 않으므로 apache client pooling 기능을 사용하여 생성한다.
     * 
     * @return {@code RestTemplate}
     */
    @Bean(name = "restTemplate")
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(5000); // 읽기 시간 초과, ms
        factory.setConnectTimeout(3000); // 연결 시간 초과, ms
        HttpClient httpClient = HttpClientBuilder.create() //
                .setMaxConnTotal(1000) // connection pool 적용 : 전체 max 수
                .setMaxConnPerRoute(100) // connection pool 적용 : [host:port] pair 당 max 수
                .build();
        factory.setHttpClient(httpClient); // 실행에 사용될 HttpClient 세팅
        return new RestTemplate(factory);
    }
}
