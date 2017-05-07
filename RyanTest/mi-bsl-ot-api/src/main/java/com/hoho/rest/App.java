package com.hoho.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages={"com.hoho.rest"})
@SpringBootApplication
public class App {
	// 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例  
    @Autowired  
    private RestTemplateBuilder builder;  
  
    @Bean  
    public RestTemplate restTemplate() {  
        return builder.build();  
    }  
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
