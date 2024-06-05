package com.project.OrdersService.repo;

import org.springframework.data.repository.CrudRepository;

import com.project.OrdersService.model.Order;

public interface Repo extends CrudRepository<Order, Long> {
	
}
