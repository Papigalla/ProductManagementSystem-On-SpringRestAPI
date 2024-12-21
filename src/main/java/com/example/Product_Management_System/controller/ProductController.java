package com.example.Product_Management_System.controller;



import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product_Management_System.entity.Product;
import com.example.Product_Management_System.service.ProductService;
import com.example.Product_Management_System.util.ResponseStructure;

@RestController
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@PostMapping("/save-product")
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product)
	{
		product=productService.add(product);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(),"Successfully created",product));
	}
	@GetMapping("/display-product")
	public ResponseEntity<ResponseStructure<Product>> display(@RequestParam("product_id") int productId)
	{
		Product product=productService.displayProduct(productId);
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(),"product is found", product));
	}
	@DeleteMapping("delete-product")
	public ResponseEntity<ResponseStructure<Product>> delete(@RequestParam("product_id") int productId)
	{
	    Product	product=productService.deleteProduct(productId);
	    return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.create(HttpStatus.OK.value(),"Product delete successfully",product));
	}
	@PutMapping("/update-product")
	public ResponseEntity<ResponseStructure<Product>> update(@RequestBody Product product)
	{
		productService.updateProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.create(HttpStatus.OK.value(),"updated Successfully", product));
	}
}
