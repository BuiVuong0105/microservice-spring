package vn.com.vuong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.vuong.model.Customer;
import vn.com.vuong.service.CustomerService;
import vn.com.vuong.service.ProductService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ProductService productService;
	
	@Override
	public Customer getCustomer() {
		Customer customer = new Customer(1, "Bui Van Vuong", productService.search());
		return customer;
	}
}
