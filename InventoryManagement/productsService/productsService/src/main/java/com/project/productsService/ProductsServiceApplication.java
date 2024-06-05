package com.project.productsService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.project.productsService.model.Product;
import com.project.productsService.repository.Repo;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(Repo repo) {
		return args->{
			Product a = new Product();
			a.setId(1);
			a.setName("phone");
			a.setQuantity(3);
			repo.save(a);
			
			Product b = new Product();
			b.setId(2);
			b.setName("laptop");
			b.setQuantity(3);
			repo.save(b);
		};
	}
}
