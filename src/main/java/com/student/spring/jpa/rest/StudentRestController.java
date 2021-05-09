package com.student.spring.jpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.spring.jpa.entity.Student;
import com.student.spring.jpa.service.StudentService;

@Controller
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public String findAll(Model theModel) {
		List<Student> theStudents = studentService.findAll();
		theModel.addAttribute("students", theStudents);
		return "students/list-students";
	}


	
	@GetMapping("/addStudentForm")
	public String showFormForAdd(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "students/student-form";
	}

	
	@PostMapping("/addStudent")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {
		
		//theStudent.setId(0);
		
		studentService.save(theStudent);
		
		return "redirect:/api/students";
	}
	
	@GetMapping("/updateStudentForm")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		Student theStudent = studentService.findById(theId);
		theModel.addAttribute("student", theStudent);

		return "students/student-form";
	}
	
	@GetMapping("delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/api/students";
	}
	
	
}
