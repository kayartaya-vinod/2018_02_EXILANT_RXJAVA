package reactive.programs;

import reactive.repository.ProductRepository;
import reactive.repository.ProductRepositoryImpl;

public class P06_ProductRepositoryTest {

	public static void main(String[] args) {
		
		ProductRepository pr = new ProductRepositoryImpl();
		
//		pr.getAllProducts()
//			.stream()
//			.forEach(p->System.out.println(p.getName()));
		
		pr.getAllProductsAsync()
			.doOnNext(p->System.out.println(p.getName()))
			.subscribe();
		
	
		
	}
}
