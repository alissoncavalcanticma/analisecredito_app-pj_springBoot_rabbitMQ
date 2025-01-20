package com.ctfera.analisecredito;

import com.ctfera.analisecredito.service.strategy.AnaliseCreditoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@AllArgsConstructor
@SpringBootApplication
public class Main {

	//Inicializado via construtor Lombok, AllArgsConstructor
	private AnaliseCreditoService analiseCreditoService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			analiseCreditoService.analisar();
		};
	}

}
