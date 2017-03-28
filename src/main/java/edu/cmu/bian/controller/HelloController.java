package edu.cmu.bian.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	@RequestMapping(method=RequestMethod.GET,value="saurzcode/hello")
	public String sayHello() {
		return "Greetings from SaurzCode! ";
	}

}
