package com.springmongodb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springmongodb.demo.model.Student;
import com.springmongodb.demo.service.MongoDBDemoService;

@RestController
@RequestMapping("v1/rest/")
public class MongoDBDemoController {

	@Autowired
	MongoDBDemoService service;

	@GetMapping("student/{name}")
	public List<Student> findStudentByName(@PathVariable("name") String name) {
		return service.findStudentByName(name);
	}

	@GetMapping("emailFilter")
	public List<Student> findStudentByEmail(@RequestParam String email) {
		System.out.println("Inside email filter......" + email);
		return service.findEmailLike(email);
	}

	@GetMapping("emailStarts")
	public List<Student> findStudentByEmailStarts(@RequestParam String email) {
		System.out.println("Inside email filter......" + email);
		return service.findByEmailStartingWith(email);
	}

	@GetMapping("findByNameAndEmail")
	public List<Student> findStudentByEmailStarts(@RequestParam String name, @RequestParam String email) {
		System.out.println("Inside email filter......" + name + " and " + email);
		return service.findByNameAndEmail(name, email);
	}

	@PostMapping("student/save")
	public Student findStudentByEmail(@RequestBody Student student) {
		return service.save(student);
	}

}
