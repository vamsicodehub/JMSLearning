package com.springmongodb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmongodb.demo.model.Student;

@Service
public class MongoDBDemoService {
	
	@Autowired
	MongoDBDemoRepository mongoRepository;

	public List<Student> findStudentByName(String name) {
		return mongoRepository.findByName(name);
	}

	public List<Student> findEmailLike(String email) {
		return mongoRepository.findByEmailLike(email);
	}
	
	public List<Student> findByEmailStartingWith(String email) {
		return mongoRepository.findByEmailStartingWith(email);
	}
	
	public List<Student> findByNameAndEmail(String name, String email) {
		return mongoRepository.findByNameAndEmail(name, email);
	}

	public Student save(Student student) {
		return mongoRepository.save(student);
	}

}
