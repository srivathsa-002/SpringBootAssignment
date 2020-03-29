package com.assignment.springboot.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.springboot.demo.details.Student;

@RestController
public class RestDemoController {

	@Autowired
	private Student student;
	
	@GetMapping("/student")
	public String studentDetails() {
		return student.studentDetails();
	}
	
}
