package br.com.app.bastoscorreios.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

	@Bean
	public RestTemplate getRestTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		List<ClientHttpRequestInterceptor> clientHttpRequestInterceptors = restTemplate.getInterceptors();
		
		if(CollectionUtils.isEmpty(clientHttpRequestInterceptors)) {
			clientHttpRequestInterceptors = new ArrayList<>();
		}
		
		restTemplate.setInterceptors(clientHttpRequestInterceptors);
		
		return restTemplate;
	}
}
