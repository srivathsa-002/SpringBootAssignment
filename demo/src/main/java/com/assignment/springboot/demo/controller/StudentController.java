package com.assignment.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.springboot.demo.entity.Student;
import com.assignment.springboot.demo.service.StudentService;


@Controller
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/list")
	public String listStudents(Model theModel) {
		
		List<Student> theStudents = studentService.findAll();
		
		theModel.addAttribute("students",theStudents);
		
		return "list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Student theStudent = new Student();
		
		theModel.addAttribute("student",theStudent);
		
		return "student-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId , Model theModel) {
		
		Student theStudent = studentService.findById(theId);
		
		theModel.addAttribute("student",theStudent);
		
		return "student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {
		
		studentService.save(theStudent);
		
		return "redirect:/students/list";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		studentService.deleteById(theId);
		
		return "redirect:/students/list";
		
	}
	
	
}
