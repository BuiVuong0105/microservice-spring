package vn.com.vuong.service;

import java.util.List;
import java.util.Optional;

import vn.com.vuong.entity.Product;

public interface ProductService {
	List<Product> search();
	Optional<Product> findById(Integer id);
}
