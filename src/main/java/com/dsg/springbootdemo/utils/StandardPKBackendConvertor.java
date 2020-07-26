package com.dsg.springbootdemo.utils;

import java.io.Serializable;

import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import com.dsg.springbootdemo.Standard;


@Component
public class StandardPKBackendConvertor implements BackendIdConverter {
	
	@Override
	public Serializable fromRequestId(String id, Class<?> entityType) {

		if(!id.contains("_")) {
			throw new IllegalArgumentException("Param `id` must contain '_' to separate columns. Expected \"std_section\", got " + id);
		}
		
		String[] parts = id.split("_");
		
		if(parts.length != 2) {
			throw new IllegalArgumentException("Param `id` invalid. Expected \"std_section\", got " + id);
		}
		
		return new Standard.StandardPK(Integer.parseInt(parts[0]), parts[1]);
	}
	
	@Override
	public String toRequestId(Serializable source, Class<?> entityType) {
	
		Standard.StandardPK id = (Standard.StandardPK) source;
		return id.getStd() + "_" + id.getSection();
		//return id.toString();
	}
	
	@Override
	public boolean supports(Class<?> type) {
		return Standard.StandardPK.class.equals(type);
	}
}
