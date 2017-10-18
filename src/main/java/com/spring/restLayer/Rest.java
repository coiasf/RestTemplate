package com.spring.restLayer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.spring.main.RestTemplateImplementation;
import com.spring.main.ResponseWrapper;

 public class Rest<T> {
	
	private HttpEntity headers = null;
	private final RestTemplate restTemplate = new RestTemplate();
	
	private final RestTemplateImplementation rest =  new RestTemplateImplementation<T>();
	
	public Rest(T body, MultiValueMap<String, String> headers) {
		this.setHttpHeaders(body, headers);		
	}
	
	private void setHttpHeaders(T body, MultiValueMap<String, String> headers) {
		this.headers = new HttpEntity<T>(body, headers);
	}
	
	public <T> ResponseWrapper<T> get(String url,Class<T> classInstance) throws Exception{
		try {
			return rest.call(restTemplate,url, HttpMethod.GET,null,classInstance);		
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public  <T> ResponseWrapper<T> post(String url,Class<T> classInstance) throws Exception {
		try {
			return rest.call(restTemplate,url, HttpMethod.POST,this.headers,classInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	public  <T> ResponseWrapper<T> put(String url,HttpEntity request,Class<T> classInstance) throws Exception{
		try {
			return rest.call(restTemplate,url, HttpMethod.PUT,null,classInstance);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public  <T> ResponseWrapper<T> delete(String url,HttpEntity request,Class<T> classInstance) throws Exception{
		try {
			return rest.call(restTemplate,url, HttpMethod.DELETE,null,classInstance);
		} catch (Exception e) {
			throw e;
		}
	}
}
