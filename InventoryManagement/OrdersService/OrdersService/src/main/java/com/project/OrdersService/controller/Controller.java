package com.project.OrdersService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


import com.project.OrdersService.model.Order;
import com.project.OrdersService.repo.Repo;
import com.project.OrdersService.service.toService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;

@RestController

public class Controller {
	@Autowired
	Repo repo ;
	
	@Autowired
	toService toservice;
	

	
	@RequestMapping(method=RequestMethod.GET ,value="/order")
	public List<Order> findAll(){
		List<Order> o = new ArrayList<>();
		repo.findAll().forEach(x->o.add(x));
		return o;
	}
	
	@CircuitBreaker(name = "products", fallbackMethod = "fallbackMethod")
	@RequestMapping(method=RequestMethod.POST , value="/createOrder" )
	public String CreateOrder(@RequestBody Order order) {
		return toservice.CreateOrder(order);
	}
	
	 public String fallbackMethod(Order order, RuntimeException runtimeException) {
	        return "Cant send the request";
	    }
	

}
