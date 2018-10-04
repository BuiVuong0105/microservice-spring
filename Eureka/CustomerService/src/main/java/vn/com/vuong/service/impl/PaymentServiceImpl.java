package vn.com.vuong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.com.vuong.consumer.ProductConsumer;
import vn.com.vuong.entity.Customer;
import vn.com.vuong.entity.Payment;
import vn.com.vuong.entity.Product;
import vn.com.vuong.exception.DataFailException;
import vn.com.vuong.exception.Error;
import vn.com.vuong.service.CustomerService;
import vn.com.vuong.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductConsumer productConsumer;

	public List<Payment> search(Integer customerId, Integer productId) {
		List<Payment> payments = new ArrayList<>();
		Customer customer = customerService.findById(customerId).orElse(null);
		Product product = null;
		ResponseEntity<?> responseEntity = productConsumer.findProductById(productId).orElse(null);
		if(responseEntity.getStatusCode() != HttpStatus.OK) {
			Error error = (Error) responseEntity.getBody();
			throw new DataFailException(error.getCode(), error.getMessage());
		}
		product = (Product) responseEntity.getBody();
		payments.add(new Payment(customer, product));
		return payments;
	}
}
