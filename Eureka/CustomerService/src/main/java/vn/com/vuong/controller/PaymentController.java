package vn.com.vuong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vuong.entity.Payment;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.service.PaymentService;
import vn.com.vuong.util.API;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value = API.Payment.SEARCH_PAYMENT)
	public ResponseEntity<DataResult<Payment>> getCustomer(@RequestParam Integer customerId, @RequestParam Integer productId) {
		List<Payment> payments = paymentService.search(customerId, productId);
		return new ResponseEntity<DataResult<Payment>>(new DataResult<>(payments.size(), payments), HttpStatus.OK);
	}
}
