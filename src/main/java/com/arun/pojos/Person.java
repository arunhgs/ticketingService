package com.arun.pojos;

import com.ticket.constants.Gender;

public class Person {

	private String name;
	private Gender gender;
	private String location;
	private Integer salary;
	private Integer age;

	public Person(String name, Gender gender, String location, Integer salary, Integer age) {
		super();
		this.name = name;
		this.gender = gender;
		this.location = location;
		this.salary = salary;
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
