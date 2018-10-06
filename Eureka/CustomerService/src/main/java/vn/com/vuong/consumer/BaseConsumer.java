package vn.com.vuong.consumer;

import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import vn.com.vuong.service.impl.RestTemplateResponseErrorHandler;

@Data
@AllArgsConstructor
public abstract class BaseConsumer {
	
	private RestTemplate restTemplate;
	
	public BaseConsumer() {
		restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
	}
}
