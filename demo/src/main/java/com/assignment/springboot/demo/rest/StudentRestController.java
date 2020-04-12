package com.assignment.springboot.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.springboot.demo.entity.Student;
import com.assignment.springboot.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private StudentService studentService;
	
	@Autowired
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		Student theStudent = studentService.findById(studentId);
		if(theStudent == null)
			throw new RuntimeException("Student Id Not Found - " + studentId);
		return theStudent;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		student.setId(0);
		studentService.save(student);
		return student;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		studentService.save(student);	
		return student;
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		Student tempStudent = studentService.findById(studentId);
		if(tempStudent == null)
			throw new RuntimeException("Student Id Not Found - " + studentId);
		studentService.deleteById(studentId);
		return "Deleted Student Id - " + studentId;
	}
}
