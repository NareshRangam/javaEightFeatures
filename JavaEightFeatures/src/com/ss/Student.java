package com.ss;

public class Student {

	private String name;
	private Integer age;
	private String college;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Student(String name, Integer age, String college) {
		super();
		this.name = name;
		this.age = age;
		this.college = college;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", college=" + college + "]";
	}
	
	
}
