package com.dsg.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/students")
	public Iterable<Student> getAll(){
		return repo.findAll();
	}
	
	@PutMapping("/students")
	public Student save(@RequestBody Student student){
		return repo.save(student);
	}
}
