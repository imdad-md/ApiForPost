package com.postApi.apiforPost;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiforPostApplication {

	public static void main(String[] args) {

		SpringApplication.run (ApiforPostApplication.class , args);
	}

@Bean
public ModelMapper check(){

		return new ModelMapper();
	}

}
