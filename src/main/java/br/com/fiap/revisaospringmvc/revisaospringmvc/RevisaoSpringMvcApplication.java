package br.com.fiap.revisaospringmvc.revisaospringmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({ "br.com.fiap.revisaospringmvc.revisaospringmvc.controller"})

public class RevisaoSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevisaoSpringMvcApplication.class, args);
	}

}
