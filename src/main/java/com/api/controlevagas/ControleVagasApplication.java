package com.api.controlevagas;

import com.api.controlevagas.setup.APIConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({APIConfig.class})
public class ControleVagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleVagasApplication.class, args);
	}

}