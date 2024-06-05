package com.project.apiGateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping("/portCheck")
	public String portCheck() {
		return "Check";
	}

}
