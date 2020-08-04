package com.dsg.springbootdemo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;

import com.dsg.springbootdemo.Standard.StandardPK;

@RepositoryRestResource
public interface StandardRepo extends PagingAndSortingRepository<Standard, StandardPK> {

	/*
	//@RestResource(exported=false)
	Optional<Standard> findByStdAndSection();

	@RestResource(exported=false)
	boolean existsByStdAndSection(StandardPK stdPk);

	@RestResource(exported=false)
	@Override
	Iterable<Standard> findAllById(Iterable<Integer> ids);

	@RestResource(exported=false)
	@Override
	void deleteById(Integer id);*/
}
