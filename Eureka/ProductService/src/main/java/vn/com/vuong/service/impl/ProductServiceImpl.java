package vn.com.vuong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.vuong.model.Product;
import vn.com.vuong.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> search() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "SP1"));
		products.add(new Product(2, "SP2"));
		products.add(new Product(3, "SP3"));
		return products;
	}
}
