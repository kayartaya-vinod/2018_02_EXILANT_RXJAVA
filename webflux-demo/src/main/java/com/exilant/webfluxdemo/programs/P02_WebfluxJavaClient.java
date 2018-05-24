package com.exilant.webfluxdemo.programs;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.exilant.webfluxdemo.model.Employee;

public class P02_WebfluxJavaClient {
	public static void main(String[] args) {
		
		String endpoint = "http://localhost:9999/rest/employees";
		WebClient cl = WebClient.create(endpoint);
		cl.get()
			.accept(MediaType.TEXT_EVENT_STREAM)
			.exchange()
			.doOnNext(resp -> {
				resp.bodyToFlux(Employee.class)
					.subscribe(e -> System.out.printf(
							"\n\nGot %s --> $.%.2f\n\n" , 
							e.getFullname(), e.getSalary()));
			})
			.subscribe();
		
	}
}
