package com.spring.main;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;


public class RestTemplateImplementation<T>{		
	public <T> ResponseWrapper<T> call(RestTemplate restTemplate,String url,HttpMethod method,HttpEntity<T> requestEntity, Class<T> clasa) throws Exception {			
		try {
			ResponseWrapper<T> response = new ResponseWrapper();		
			T responseString = restTemplate.exchange(
				url,
				method,	        
		        requestEntity,	       
		        clasa
		    ).getBody();		
			
			response.setResponse(responseString);
			return response;
		} catch (Exception e) {
			throw e;
		}
					
	}	
}
