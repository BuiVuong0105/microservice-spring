package vn.com.vuong.consumer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import vn.com.vuong.entity.Product;
import vn.com.vuong.exception.Error;
import vn.com.vuong.model.DataResult;
import vn.com.vuong.util.HttpHeader;
import vn.com.vuong.util.JsonUtils;

@Service
public class ProductConsumer {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancer;

	public Optional<ResponseEntity<?>> search() {
//		List<ServiceInstance> instances = discoveryClient.getInstances(vn.com.vuong.util.Service.PRODUCT_SERVICE);
		List<ServiceInstance> instances = discoveryClient.getInstances(vn.com.vuong.util.Service.ZUUL_SERVICE);
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/productservice/products";
		System.out.println("BASEUERL: " + baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, HttpHeader.getHeaders(), DataResult.class);
		} catch (HttpClientErrorException e) {
			Error error = JsonUtils.toObject(e.getResponseBodyAsString(), Error.class);
			response = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(response);
	}

	public Optional<ResponseEntity<?>> findProductById(Integer productId) {
//		ServiceInstance serviceInstance = loadBalancer.choose(vn.com.vuong.util.Service.PRODUCT_SERVICE);
		ServiceInstance serviceInstance = loadBalancer.choose(vn.com.vuong.util.Service.ZUUL_SERVICE);
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/productservice/product/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, HttpHeader.getHeaders(), Product.class);
		} catch (HttpClientErrorException e) {
			Error error = JsonUtils.toObject(e.getResponseBodyAsString(), Error.class);
			response = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(response);
	}
}
