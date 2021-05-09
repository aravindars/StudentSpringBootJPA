package com.student.spring.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.spring.jpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
