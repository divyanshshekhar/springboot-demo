package com.dsg.springbootdemo;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="inlineStandards", types= {Standard.class})
public interface InlineStandardProjection {
	Integer getId();
	Integer getRollNo();
	String getName();
	String getEmail();
	Standard getStandard();
}
