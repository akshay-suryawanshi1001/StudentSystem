package com.akshay.studentsystem.service;

import java.util.List;

import com.akshay.studentsystem.model.Student;

public interface StudentService {
	public Student saveStudent(Student stud);
	public List<Student> getAllStudents();
}
