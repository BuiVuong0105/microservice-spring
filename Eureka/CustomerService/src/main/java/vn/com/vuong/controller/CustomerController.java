package vn.com.vuong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vuong.model.Customer;
import vn.com.vuong.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/customer")
	public ResponseEntity<Customer> getCustomer() {
		Customer customer = customerService.getCustomer();
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
