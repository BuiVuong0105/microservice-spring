package vn.com.vuong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vuong.entity.Customer;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.service.CustomerService;
import vn.com.vuong.util.API;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = API.Customer.SEARCH_CUSTOMER)
	public ResponseEntity<DataResult<Customer>> getCustomer() {
		List<Customer> customers = customerService.search();
		return new ResponseEntity<DataResult<Customer>>(new DataResult<>(customers.size(), customers), HttpStatus.OK);
	}
}
