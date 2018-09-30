package vn.com.vuong.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.com.vuong.consumer.ProductService;
import vn.com.vuong.entity.Customer;
import vn.com.vuong.entity.Product;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.service.CustomerService;
import vn.com.vuong.util.JsonUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ProductService productService;
	
	@Override
	public List<Customer> search() {
		List<Product> products  = new ArrayList<>();
		ResponseEntity<?> responseEntity = productService.search().orElse(null);
		if(responseEntity != null) {
			if(responseEntity.getStatusCode() != HttpStatus.OK) {
				DataResult<Product> dataResult = JsonUtils.toObject(responseEntity.getBody(), DataResult.class);
				products = dataResult.getResults();
			}
		}
		List<Customer> customers = new ArrayList<>();
		Customer customer = new Customer(1, "Bui Van Vuong", products);
		customers.add(customer);
		return customers;
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		Customer customer = new Customer(1, "Bui Van Vuong", null);
		return Optional.ofNullable(customer);
	}
}
