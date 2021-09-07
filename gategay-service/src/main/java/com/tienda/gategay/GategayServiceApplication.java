package com.tienda.gategay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GategayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GategayServiceApplication.class, args);
	}

}
