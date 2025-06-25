package com.fdmgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class SpringBootContactRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootContactRestServiceApplication.class, args);
	}

}
