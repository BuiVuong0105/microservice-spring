package vn.com.vuong.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.vuong.consumer.ProductService;
import vn.com.vuong.entity.Customer;
import vn.com.vuong.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ProductService productService;
	
	@Override
	public List<Customer> search() {
		List<Customer> customers = new ArrayList<>();
		Customer customer = new Customer(1, "Bui Van Vuong", productService.search());
		customers.add(customer);
		return customers;
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		Customer customer = new Customer(1, "Bui Van Vuong", null);
		return Optional.ofNullable(customer);
	}
}
