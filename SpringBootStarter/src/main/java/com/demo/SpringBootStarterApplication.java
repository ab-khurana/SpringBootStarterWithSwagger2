package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex; 

@SpringBootApplication
@EnableSwagger2
public class SpringBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterApplication.class, args);
	}
	
	@Bean
	public Docket allApi(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("ALL Services").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.controller")).paths(regex("/.*")).build();
		}
	private ApiInfo apiInfo(){
			return new ApiInfoBuilder().title("").description("Create and Edit").contact("")
					.license("1.0").version("1.0").build();
			} 
}
