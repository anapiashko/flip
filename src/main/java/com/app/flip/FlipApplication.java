package com.app.flip;

import com.app.flip.dao.CardRepository;
import com.app.flip.model.Card;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class FlipApplication implements CommandLineRunner {

	@Autowired
	private CardRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(FlipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		Path path = Paths.get("src","main", "resources", "records", "silly.mp3");
		repository.save(new Card(2, "I don't dare ask such a silly question.",
				"Я не решаюсь задать такой глупый вопрос.", new Binary(Files.readAllBytes(path))));

		// fetch all customers
		System.out.println("Cards found with findAll():");
		System.out.println("-------------------------------");
		for (Card card : repository.findAll()) {
			System.out.println(card);
		}
		System.out.println();
	}
}
