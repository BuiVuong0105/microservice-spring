package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.Customer;

public interface CustomerService {
	List<Customer> search();
	Optional<Customer> findById(Integer id);
}
