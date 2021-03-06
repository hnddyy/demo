package com.example.demo;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")).paths(PathSelectors.any())
				.build().securitySchemes(Collections.singletonList(apiKey()))
				.globalOperationParameters(newArrayList(new ParameterBuilder().name("userId")
						.description("로그인 사용자 ID").modelRef(new ModelRef("String")).parameterType("header")
						.required(true).hidden(true).build()));
	}

	private ApiKey apiKey() {
		return new ApiKey("Authorization", "", "header");
	}

}
