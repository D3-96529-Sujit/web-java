package tester;

import java.time.LocalDate;
import java.util.Scanner;

import com.app.dao.ProductDao;
import com.app.dao.ProductDaoImpl;
import com.app.entities.Category;
import com.app.entities.Product;

public class AddProduct {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			ProductDao dao = new ProductDaoImpl();

			System.out.println("Enter Name");
			String name = sc.next();

			sc.nextLine();

			System.out.println("Enter Description");
			String desc = sc.nextLine();

			System.out.println("Enter Manufacture Date (yyyy-MM-dd)");
			LocalDate mfgDate =
					LocalDate.parse(sc.next());

			System.out.println("Enter Price");
			double price = sc.nextDouble();

			System.out.println("Enter Quantity");
			int qty = sc.nextInt();

			System.out.println("Enter Category");
			Category category =
					Category.valueOf(sc.next().toUpperCase());

			Product product = new Product(
					name,
					desc,
					mfgDate,
					price,
					qty,
					category);

			System.out.println(
					dao.addProduct(product));
		}
	}
}