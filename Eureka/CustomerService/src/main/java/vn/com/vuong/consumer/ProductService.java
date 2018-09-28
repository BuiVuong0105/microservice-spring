package vn.com.vuong.consumer;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import vn.com.vuong.entity.Product;

public interface ProductService {
	List<Product> search();
	Optional<ResponseEntity<?>> findProductById(Integer productId);
}
