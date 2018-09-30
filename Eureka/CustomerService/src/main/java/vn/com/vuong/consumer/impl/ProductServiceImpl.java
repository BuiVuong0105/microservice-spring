package vn.com.vuong.consumer.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import vn.com.vuong.consumer.ProductService;
import vn.com.vuong.util.HttpHeader;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@Override
	public Optional<ResponseEntity<?>> search() {
		List<ServiceInstance> instances = discoveryClient.getInstances(vn.com.vuong.util.Service.PRODUCT_SERVICE);
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/products";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, HttpHeader.getHeaders(), Object.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(response);
	}

	@Override
	public Optional<ResponseEntity<?>> findProductById(Integer productId) {
		ServiceInstance serviceInstance = loadBalancer.choose(vn.com.vuong.util.Service.PRODUCT_SERVICE);
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/product/"+ productId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, HttpHeader.getHeaders(), Object.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(response);
	}
}
