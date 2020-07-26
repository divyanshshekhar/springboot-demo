package com.dsg.springbootdemo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface StandardRepo extends PagingAndSortingRepository<Standard, Integer> {
	
}
