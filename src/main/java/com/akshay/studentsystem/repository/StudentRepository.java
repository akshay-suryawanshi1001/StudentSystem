package com.akshay.studentsystem.repository;

import org.springframework.stereotype.Repository;

import com.akshay.studentsystem.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
