package com.example.samplerestsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.example.samplerestsv.app", "com.example.samplerestsv.service"})
public class SampleRestSvApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleRestSvApplication.class, args);
	}
}
