package com.exilant.webfluxdemo.repository;

import java.util.List;

import com.exilant.webfluxdemo.model.Product;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;

public interface ProductRepository {
	
	// non-reactive
	public List<Product> getAllProducts();
	
	// reactive (asynchronous, observable stream) - RxJava based
	public Observable<Product> getAllProductsAsync();
	
	// reactive (asynchronous, observable stream) - Spring Flux based
	public Flux<Product> getAllProductsAsFlux();
}
