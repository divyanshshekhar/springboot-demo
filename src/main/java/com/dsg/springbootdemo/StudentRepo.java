package com.dsg.springbootdemo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepo extends PagingAndSortingRepository<Student, Integer> {
	
}
