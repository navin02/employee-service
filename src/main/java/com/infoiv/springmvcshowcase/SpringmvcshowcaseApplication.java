package com.infoiv.springmvcshowcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringmvcshowcaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcshowcaseApplication.class, args);
	}

}

