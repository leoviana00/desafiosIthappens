package com.desafioih.leoviana.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/desafio")
public class DesafioApplicationController {

        @GetMapping
        public String desafio() {
        return "Desafio01 | Spring Framework | Hello World";
    }

}
