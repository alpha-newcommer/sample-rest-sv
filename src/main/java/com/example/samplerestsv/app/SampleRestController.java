package com.example.samplerestsv.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.samplerestsv.model.User;
import com.example.samplerestsv.service.UserService;

@RestController
@RequestMapping("/api/sample")
public class SampleRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("hello")
	public SampleResource hello() {
		SampleResource sr = new SampleResource();
		sr.setMessage("hello world");
		return sr;
	}
	
	@RequestMapping(value = "user/{userId}")
	public SampleResource user(@PathVariable int userId) {
		User user = userService.getUser(userId);
		SampleResource sr = new SampleResource();
		sr.setMessage(user.getName() + " is " + user.getAge() + " years old.");
		return sr;
	}
}
