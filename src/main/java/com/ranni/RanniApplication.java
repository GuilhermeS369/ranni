package com.ranni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.zuoyan.springboot.appmissionhall"})
@EnableSwagger2
public class RanniApplication {

	public static void main(String[] args) {
		SpringApplication.run(RanniApplication.class, args);
		
		
	}

}
