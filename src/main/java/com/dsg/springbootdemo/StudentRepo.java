package com.dsg.springbootdemo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

@RepositoryRestResource(excerptProjection = InlineStandardProjection.class)
public interface StudentRepo extends PagingAndSortingRepository<Student, Integer> {
	
}
