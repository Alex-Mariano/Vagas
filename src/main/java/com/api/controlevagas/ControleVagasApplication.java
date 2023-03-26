package com.api.controlevagas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ControleVagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleVagasApplication.class, args);
	}

}
// https://www.youtube.com/watch?v=LXRU-Z36GEU