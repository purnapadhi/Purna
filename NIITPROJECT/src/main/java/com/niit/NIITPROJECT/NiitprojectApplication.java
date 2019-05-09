package com.niit.NIITPROJECT;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSpringConfigured
public class NiitprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiitprojectApplication.class, args);
		/*ApplicationContext applicationContext = SpringApplication.run(NiitprojectApplication.class, args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}*/
	}

}
