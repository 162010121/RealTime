package com.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BackenRecipeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackenRecipeProjectApplication.class, args);
	}

}
