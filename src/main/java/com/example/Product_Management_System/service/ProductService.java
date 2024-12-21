package com.example.Product_Management_System.service;



import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Product_Management_System.entity.Product;
import com.example.Product_Management_System.exception.ProductNotFoundById;
import com.example.Product_Management_System.repository.ProductRepository;
@Service
public class ProductService {
	private final ProductRepository productRepository;
	

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}


	public Product add(Product product) {
		return productRepository.save(product);
	}


	public Product displayProduct(int productId) {
		return productRepository.findById(productId).orElseThrow(()->new ProductNotFoundById("Please Enter valued ProductId"));
	}


	public Product deleteProduct(int productId) {
	Optional<Product>	optional=productRepository.findById(productId);
	if(optional.isPresent())
	{
	    Product product	=optional.get();
	    productRepository.delete(product);
	    return product;
	}else
	{
		 throw new ProductNotFoundById("Product is not there");
	}
	}


	public Product updateProduct(Product product) {
	Optional<Product>optional=productRepository.findById(product.getProductId());
	if(optional.isPresent())
	{
		return productRepository.save(product);
	}
	else
	{
		throw new ProductNotFoundById("Product Not Updated");
	}
	}

	
	}

