package com.exilant.webfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@EnableMongoRepositories
@SpringBootApplication
public class WebfluxDemoApplication extends AbstractReactiveMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxDemoApplication.class, args);
	}

	@Override
	public MongoClient reactiveMongoClient() {
		return MongoClients.create(); // mongodb://localhost:27017
	}

	@Override
	protected String getDatabaseName() {
		return "mydb"; // default name is "test"
	}
}
