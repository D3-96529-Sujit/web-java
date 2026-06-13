package com.app.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "products")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(length = 50, unique = true)
	private String name;
	
	@Column(length = 300)
	private String productDescription;
	
	private LocalDate manfactureDate;
	
	private Double price;
	
	private Integer availableQuantity;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	public Product()
	{
		
	}

	public Product( String name, String productDescription, LocalDate manfactureDate, Double price,
			Integer availableQuantity, Category category) {
		super();
		
		this.name = name;
		this.productDescription = productDescription;
		this.manfactureDate = manfactureDate;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.category = category;
	}
	
	public Long getProductId()
	{
		return productId;
		
	}
	
	
	public String getName()
	{
		return name;
	}
	
	

	public String getProductDescription() {
		return productDescription;
	}

	public LocalDate getManfactureDate() {
		return manfactureDate;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public Category getCategory() {
		return category;
	}

	
	@Override
	
	public String toString()
	{
		return
		"Product [productId=" + productId +
		", name=" + name +
		", productDescription=" + productDescription +
		", manufactureDate=" + manfactureDate +
		", price=" + price +
		", availableQuantity=" + availableQuantity +
		", category=" + category + "]";
	}

	
	
	
	
	
	
	

}
