package com.exilant.webfluxdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Employee {
	@Id
	private String id;
	@Field("name")
	private String fullname;
	private Double salary;

	public Employee(String fullname, Double salary) {
		this.fullname = fullname;
		this.salary = salary;
	}

}
