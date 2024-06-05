package com.project.productsService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.productsService.model.Product;
import com.project.productsService.repository.Repo;

@RestController
public class Controller {
	

	
	@Autowired
	 Repo repo;
	
	@RequestMapping("/getProducts")
	public List<Product> getDetails() {
		List<Product> c = new ArrayList();
		 repo.findAll().forEach(x->c.add(x)) ;
		 return c;
	}
	
	
	@RequestMapping(method=RequestMethod.GET ,value="/checkProducts/{product}")
	public String check(@PathVariable("product") String product) {	
		
	List<String> e = new ArrayList(); 
	   
		getDetails().forEach(x-> {
			if(x.getName().equalsIgnoreCase(product)&&x.getQuantity()!=0) {
				e.add("Got");
				int c =x.getQuantity()-1;
				Product b = new Product();
				b.setId(x.getId());
				b.setName(x.getName());
				b.setQuantity(c);
				repo.save(b);
				/*  */
			}
		
		});
		if(e.isEmpty()) {
			return "NotGot";
		}
		else {
			String k = e.get(0);
			return k;
		}
		
	}
	
	
	
	
	
	

}