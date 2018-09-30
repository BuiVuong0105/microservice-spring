package vn.com.vuong.consumer;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface ProductService {
	Optional<ResponseEntity<?>> search();
	Optional<ResponseEntity<?>> findProductById(Integer productId);
}
