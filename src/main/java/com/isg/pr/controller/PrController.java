package com.isg.pr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.isg.pr.UserModel;
import com.isg.pr.UserRepo;


@RestController
public class PrController {

	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/whoAmI")
	public String whoAmI() {
		System.out.println("am from pr version 1.0 application");
		return "am from pr version 1.0 application";
	}
	
	@GetMapping("/addEmp/{id}/{name}")
	public UserModel saveaddEmp(@PathVariable Integer id, @PathVariable String name) {
		UserModel um = new UserModel();
		um.setName(name);
		um.setUserId(id);
		return userRepo.save(um);
	}
	
	@GetMapping("/getAllFromMysql")
	public List<UserModel> getAllFromMysql(){
		return userRepo.findAll();
	}
}
