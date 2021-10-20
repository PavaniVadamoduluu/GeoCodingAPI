package com.GeocodingAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.GeocodingAPI.controller.GeocodingController;

@SpringBootApplication
@ComponentScan(basePackageClasses = GeocodingController.class)
public class GeocodingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeocodingApiApplication.class, args);
	}

}
