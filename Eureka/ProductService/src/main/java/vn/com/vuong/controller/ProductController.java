package vn.com.vuong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vuong.model.Product;
import vn.com.vuong.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> search() {
		List<Product> products = productService.search();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
