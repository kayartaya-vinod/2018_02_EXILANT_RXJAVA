package reactive.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import reactive.model.Product;

public class ProductRepositoryImpl implements ProductRepository {

	private Connection createConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:h2:tcp://localhost/~/test1";
		String username = "sa";
		String password = "";
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection(url, username, password);
	}
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = createConnection();
			stmt = conn.prepareStatement("select * from products");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt("id") ,
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("unit_price"));
				list.add(p);
				System.out.println("Inside getAllProducts(), p.getName()="+p.getName());
			}
			return list;
			
		} catch (Exception e) {
			// ducking the exception
			// VERY VERY BAD IDEA
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				
			}
		}
		
		return null;
	}

	@Override
	public Observable<Product> getAllProductsAsync() {
		return Observable.create(sub->{
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from products");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt("id") ,
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("unit_price"));
				
				
				System.out.println("Inside getAllProductsAsync(), p.getName()="+p.getName());
				
				// emit the data to all the subscribers
				sub.onNext(p);
			}
			rs.close();
			stmt.close();
			conn.close();
			sub.onComplete();
		});
	}

}
















