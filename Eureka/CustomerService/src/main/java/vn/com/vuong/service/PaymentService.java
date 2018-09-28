package vn.com.vuong.service;

import java.util.List;

import vn.com.vuong.entity.Payment;

public interface PaymentService {
	List<Payment> search(Integer customerId, Integer productId);
}
