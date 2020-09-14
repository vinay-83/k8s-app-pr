package com.isg.pr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrController {

	@GetMapping("/whoAmI")
	public String whoAmI() {
		System.out.println("am from pr version 1.0 application");
		return "am from pr version 1.0 application";
	}
}
