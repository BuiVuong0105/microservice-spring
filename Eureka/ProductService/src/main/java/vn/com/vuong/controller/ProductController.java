package vn.com.vuong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vuong.entity.Product;
import vn.com.vuong.exception.DataFailException;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.service.ProductService;
import vn.com.vuong.util.API;
import vn.com.vuong.util.Constatn;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = API.Product.SEARCH_PRODUCT)
	public ResponseEntity<DataResult<Product>> search() {
		List<Product> products = productService.search();
		if (products == null) {
			throw new DataFailException(404, "not found");
		}
		return new ResponseEntity<DataResult<Product>>(new DataResult<>(products.size(), products), HttpStatus.OK);
	}
	
	@GetMapping(value = API.Product.FIND_PRODUCT_BY_ID)
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Product product = productService
				.findById(id)
				.orElseThrow(() -> new DataFailException(Constatn.ErrorCode.NOTFOUND, "Product Not Found"));
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
