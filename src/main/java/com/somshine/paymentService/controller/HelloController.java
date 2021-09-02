package com.somshine.paymentService.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.somshine.paymentService.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelloController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public List<User> hello() {
		//Get the user information from another service which is UserSevice
		RestTemplate userService = new RestTemplate();
		
//		List<LinkedHashMap> users = userService.getForObject("http://localhost:8184/user/v1/get/2", List.class);
		List<LinkedHashMap> users = userService.getForObject("http://localhost:8184/user/v1/list", List.class);
		List<User> objUsers = new ArrayList<>();
		
		for (LinkedHashMap user: users) {
			System.err.println(user.toString());
			User objUser = new User();
			objUser.setId(Long.parseLong(user.get("id").toString()));
			objUser.setShoppeId(Integer.parseInt(user.get("id").toString()));
			objUser.setFirstName(String.valueOf(user.get("firstName")));
			objUser.setLastName(String.valueOf(user.get("lastName")));
			objUser.setMobileNo(String.valueOf(user.get("mobileNo")));
			objUser.setEmailAddress(String.valueOf(user.get("emailAddress")));
			objUser.setAddress(String.valueOf(user.get("address")));
			objUser.setAccessTypeId(Integer.parseInt(user.get("accessTypeId").toString()));
			
			objUser.setUsername(String.valueOf(user.get("username")));
			objUser.setPassword(String.valueOf(user.get("password")));

			objUsers.add(objUser);
		}
		return objUsers;
	}
}