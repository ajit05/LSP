package com.infosys.LSP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LspApplication {

	public static void main(String[] args) {
		SpringApplication.run(LspApplication.class, args);
	}

}
