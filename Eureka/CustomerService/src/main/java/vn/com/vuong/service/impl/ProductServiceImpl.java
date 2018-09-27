package vn.com.vuong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import vn.com.vuong.model.Product;
import vn.com.vuong.service.ProductService;
import vn.com.vuong.util.HttpHeader;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public List<Product> search() {
		List<Product> products = new ArrayList<>();
		List<ServiceInstance> instances = discoveryClient.getInstances(vn.com.vuong.util.Service.PRODUCT_SERVICE);
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();
		baseUrl = baseUrl + "/products";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, HttpHeader.getHeaders(), List.class);
			Product product = null;
			if(response != null) {
				products = response.getBody();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return products;
	}
}
