package com.student.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="age")
	@Min(value = 0, message = "Age should not be lesser than 0")
	@Max(value = 100, message = "Age should not be greater than 100")
	private int age;
	
	
	@Column(name="class_in")
	private int classIn;
	
	public Student() {
		
	}

	public Student(int id, String studentName, int age, int class_in) {
		this.id = id;
		this.studentName = studentName;
		this.age = age;
		this.classIn = class_in;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getClassIn() {
		return classIn;
	}

	public void setClassIn(int class_in) {
		this.classIn = class_in;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", age=" + age + ", class_in=" + classIn + "]";
	}

	
	

}
