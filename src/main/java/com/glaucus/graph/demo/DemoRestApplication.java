
package com.glaucus.graph.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.glaucus.graph.demo.repository.PersonRepository;

@EnableTransactionManagement
@EnableNeo4jRepositories
@SpringBootApplication
public class DemoRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner demo(PersonRepository personRepository) {
		return args -> {
			personRepository.deleteAll();
		};
	}
}
