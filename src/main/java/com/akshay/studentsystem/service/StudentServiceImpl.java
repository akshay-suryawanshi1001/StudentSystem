package com.akshay.studentsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.studentsystem.model.Student;
import com.akshay.studentsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student stud) {
		studentRepository.save(stud);
		System.out.println("saved student successfully");
		return stud;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> ls = new ArrayList<Student>();
		ls = studentRepository.findAll();
		return ls;
	}
	
}
