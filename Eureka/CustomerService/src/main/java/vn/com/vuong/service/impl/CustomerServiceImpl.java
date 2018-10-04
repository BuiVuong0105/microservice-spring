package vn.com.vuong.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.com.vuong.consumer.ProductConsumer;
import vn.com.vuong.entity.Customer;
import vn.com.vuong.entity.Product;
import vn.com.vuong.exception.DataFailException;
import vn.com.vuong.exception.Error;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ProductConsumer productConsumer;
	
	@Override
	public List<Customer> search() {
		List<Product> products  = new ArrayList<>();
		ResponseEntity<?> responseEntity = productConsumer.search().orElse(null);
		if(responseEntity.getStatusCode() != HttpStatus.OK) {
			Error error = (Error) responseEntity.getBody();
			throw new DataFailException(error.getCode(), error.getMessage());
		}
		DataResult<Product> dataResult = (DataResult<Product>) responseEntity.getBody();
		products = dataResult.getResults();
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
