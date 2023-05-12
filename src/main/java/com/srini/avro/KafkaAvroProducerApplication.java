package com.srini.avro;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaAvroProducerApplication implements CommandLineRunner {

	private final Producer producer ;

	public static void main(String[] args) {
		SpringApplication.run(KafkaAvroProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.send();
	}
}
