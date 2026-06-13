package tester;

import java.util.Scanner;

import com.app.dao.ProductDao;
import com.app.dao.ProductDaoImpl;
import com.app.entities.Product;

public class GetProductById {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			ProductDao dao = new ProductDaoImpl();

			System.out.println("Enter Product Id");
			Long id = sc.nextLong();

			Product product =
					dao.getProductDetails(id);

			if (product != null)
				System.out.println(product);
			else
				System.out.println(
						"Product not found !");
		}
	}
}