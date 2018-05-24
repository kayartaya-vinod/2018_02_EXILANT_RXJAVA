package reactive.repository;

import java.util.List;

import io.reactivex.Observable;
import reactive.model.Product;

public interface ProductRepository {
	
	// non-reactive
	public List<Product> getAllProducts();
	
	// reactive (asynchronous, observable stream)
	public Observable<Product> getAllProductsAsync();
	
	
}
