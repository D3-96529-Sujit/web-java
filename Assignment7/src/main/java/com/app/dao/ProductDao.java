package com.app.dao;

import com.app.entities.Product;

public interface ProductDao {
	String addProduct(Product  product);
	
	Product getProductDetails(Long productId);

}
