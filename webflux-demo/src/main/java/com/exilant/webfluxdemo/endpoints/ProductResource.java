package com.exilant.webfluxdemo.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exilant.webfluxdemo.model.Product;
import com.exilant.webfluxdemo.repository.ProductRepository;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
@RequestMapping("/rest")
public class ProductResource {

	@Autowired
	ProductRepository repo;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return repo.getAllProducts();
	}
	
	@GetMapping(path="/products-async", produces= {MediaType.TEXT_EVENT_STREAM_VALUE})
	public Observable<Product> getAllProductsAsObservable() {
		return repo.getAllProductsAsync();
	}
	
	@GetMapping(path="/products-flux", produces= {MediaType.TEXT_EVENT_STREAM_VALUE})
	public Flux<Product> getAllProductsAsFlux() {
		return repo.getAllProductsAsFlux();
	}
	
}







