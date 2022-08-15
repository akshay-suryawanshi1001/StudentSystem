package com.akshay.studentsystem.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.studentsystem.model.Student;
import com.akshay.studentsystem.service.DemoCodeExample;
import com.akshay.studentsystem.service.StudentService;

import antlr.StringUtils;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private DemoCodeExample demo;
	
	@PostMapping("/add")
	public String add(@RequestBody Student stud) {
		//if(stud == null) {
		//	stud = new Student(1 , "akshay", "krushinagar");
		//}
		service.saveStudent(stud);
		return "New Student added";
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		String line = "";
		BufferedReader reader = null;
		String file = "src\\main\\resources\\studentsystem.csv";
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] row = 	line.split(",");
				for(String index : row) {
					System.out.printf("%-10s", index);
				}
				System.out.println();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "aaaaaaaaaaaaaaaa";
	}
	
	@GetMapping("/getAllProgNames")
	@ResponseBody
	public Map getAllProNames() {
		Map<Integer, String> progNames = new HashMap<Integer, String>();
		progNames.put(1, "fibonacciSeriesWithoutRecursion");
		progNames.put(2, "fibonacciSeriesWithRecursion");
		return progNames;
	}
	
	@GetMapping("/executeProgId/{id}")
	@ResponseBody
	public String executeProgId(@PathVariable String id) {
		String progId = id;
		String result = "";
		
		switch(progId) {
			case "1" :
				result = demo.fibonacciSeriesWithoutRecursion();
				break;
			case "2" :
				demo.fibonacciSeriesWithRecursion();
				break;
		}
		if(org.springframework.util.StringUtils.isEmpty(result))
			return "Please see console log for details...";
		else
			return result;
	}
	
}
