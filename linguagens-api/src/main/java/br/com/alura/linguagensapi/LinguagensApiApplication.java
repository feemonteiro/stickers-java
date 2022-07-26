package br.com.alura.linguagensapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"br.com.alura.linguagensapi"})
@EnableMongoRepositories ("br.com.alura.linguagensapi")
public class LinguagensApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinguagensApiApplication.class, args);
	}

}
