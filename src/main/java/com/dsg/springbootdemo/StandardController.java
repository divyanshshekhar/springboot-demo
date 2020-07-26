package com.dsg.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class StandardController {
	
	@Autowired
	private StandardRepo repo;
	
	@GetMapping("/standards")
	public Iterable<Standard> getAll(){
		return repo.findAll();
	}
	
	@PutMapping("/standards")
	public Standard save(@RequestBody Standard standard){
		return repo.save(standard);
	}
}
