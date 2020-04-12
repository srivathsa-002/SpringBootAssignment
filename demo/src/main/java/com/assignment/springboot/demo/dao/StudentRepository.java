package com.assignment.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.springboot.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
