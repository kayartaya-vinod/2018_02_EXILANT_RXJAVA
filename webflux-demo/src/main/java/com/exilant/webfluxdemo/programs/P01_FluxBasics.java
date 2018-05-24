package com.exilant.webfluxdemo.programs;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class P01_FluxBasics {
	public static void main(String[] args) {
		
		Mono<String> m1 = Mono.just("vinod");
		
		m1.doOnNext(System.out::println)
			.subscribe();
		
		line();
		
		Flux<String> f1 = Flux.just("my", "name", "is", "vinod");
		f1.map(s->s.toUpperCase())
			.doOnNext(System.out::println)
			.subscribe();
		line();
		
		Flux<Long> f2 = Flux.interval(Duration.ofSeconds(2));
		
		Flux.zip(f1, f2).map(pair->pair.getT1()).subscribe(System.out::println);
	}

	static void line() {
		System.out.println("-----------------------");
	}
}
