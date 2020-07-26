package com.dsg.springbootdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint (columnNames= {"rollno","std","section"}), @UniqueConstraint (columnNames= {"email"})})
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer rollNo;
	private String name;
	private String email;
	
	@ManyToOne()
	@JoinColumn(name = "std")
	@JoinColumn(name = "section")
	private Standard standard;


	public Student() {
	}


	public Student(Integer id, Integer rollNo, String name, String email, Standard standard) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.email = email;
		this.standard = standard;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getRollNo() {
		return rollNo;
	}


	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Standard getStandard() {
		return standard;
	}


	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	
	
}
