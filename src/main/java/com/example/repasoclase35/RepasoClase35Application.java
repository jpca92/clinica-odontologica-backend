package com.example.repasoclase35;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;

@SpringBootApplication
public class RepasoClase35Application {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");

		SpringApplication.run(RepasoClase35Application.class, args);
	}

}
