package com.asia.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.asia.pay")
public class AsiaPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsiaPayApplication.class, args);
	}

}
