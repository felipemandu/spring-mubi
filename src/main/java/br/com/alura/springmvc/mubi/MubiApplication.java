package br.com.alura.springmvc.mubi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MubiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MubiApplication.class, args);
	}

}
