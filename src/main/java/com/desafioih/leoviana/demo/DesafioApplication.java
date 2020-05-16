package com.desafioih.leoviana.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@RestController
public class  DesafioApplication {

	@RequestMapping(value ="/desafio")
    public String desafio() {
    	return "Desafio01 | Spring Framework | Hello World";
    }

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}



}