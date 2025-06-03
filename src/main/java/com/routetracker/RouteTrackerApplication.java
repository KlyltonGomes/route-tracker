package com.routetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RouteTrackerApplication {

	public static void main(String[] args) {
		System.out.println("Start project");
		SpringApplication.run(RouteTrackerApplication.class, args);

		System.out.println("Let`s Go!!");
	}

}
