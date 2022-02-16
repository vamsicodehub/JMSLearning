package com.springmongodb.demo.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springmongodb.demo.model.Student;

@Repository
public interface MongoDBDemoRepository extends MongoRepository<Student, String> {

	public List<Student> findByName(String name);

	public List<Student> findByEmailLike(String email);

	public List<Student> findByEmailStartingWith(String email);

	public List<Student> findByNameAndEmail(String name, String email);

}
