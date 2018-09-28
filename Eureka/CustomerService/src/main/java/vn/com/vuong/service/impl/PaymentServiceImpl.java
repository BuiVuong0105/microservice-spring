package vn.com.vuong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.com.vuong.consumer.ProductService;
import vn.com.vuong.entity.Customer;
import vn.com.vuong.entity.Payment;
import vn.com.vuong.entity.Product;
import vn.com.vuong.service.CustomerService;
import vn.com.vuong.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	public List<Payment> search(Integer customerId, Integer productId) {
		List<Payment> payments = new ArrayList<>();
		Customer customer = customerService.findById(customerId).orElse(null);
		Product product = null;
		ResponseEntity<?> responseEntity = productService.findProductById(productId).orElse(null);
		if(responseEntity != null) {
			product = (Product) responseEntity.getBody();
		}
		payments.add(new Payment(customer, product));
		return payments;
	}
}
