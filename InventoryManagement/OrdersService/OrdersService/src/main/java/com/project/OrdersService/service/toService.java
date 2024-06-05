package com.project.OrdersService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.project.OrdersService.model.Order;
import com.project.OrdersService.repo.Repo;

import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;



@Service
@Transactional
public class toService {
	
	@Autowired
	WebClient.Builder webclient;
	
	@Autowired
	Repo repo;
	
	public String CreateOrder(@RequestBody Order order) {
		String r = null ;
		String product = order.getProduct();
// adding the products-service name instead of localhost:8081	
		String url ="http://products-service/checkProducts/" + product;
		String d = webclient.build().get().uri(url).retrieve().bodyToMono(String.class).block();
		
		if(d.equalsIgnoreCase("Got")) {
			r="Created";
			repo.save(order);
		}
		else {
			r="NotCreated";
		}
		return r;
	
	
	

}
	
}
