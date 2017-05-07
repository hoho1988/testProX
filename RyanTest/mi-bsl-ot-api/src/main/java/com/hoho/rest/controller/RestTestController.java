package com.hoho.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTestController {
	@Autowired  
    private RestTemplate restTemplate;
	
	@RequestMapping("/test")
	public String test() {
		return "hahahha";
	}
	@RequestMapping("/restGet")
	public String restGet() {
		String url = "http://localhost:8081/findAll_OT";
		return restTemplate.getForObject(url, String.class);
	}
	@RequestMapping("/restPost")
	public String restPost(String name) {
		String url = "http://localhost:8081/add_OT?name={name}";
		return restTemplate.postForObject(url, null, String.class,name);
	}
}
