package com.project.productsService.repository;

import org.springframework.data.repository.CrudRepository;
import com.project.productsService.model.Product;

public interface Repo extends CrudRepository <Product,Integer>{

}