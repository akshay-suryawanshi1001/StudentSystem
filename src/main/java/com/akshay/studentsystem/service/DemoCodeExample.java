package com.akshay.studentsystem.service;

import org.springframework.stereotype.Service;

@Service
public class DemoCodeExample {
	static int n1=0, n2=1, n3 = 0;
	public String fibonacciSeriesWithoutRecursion() {
		int n1=0, n2 = 1, count = 10, n3;
		StringBuilder sd = new StringBuilder();
		System.out.print("fibonacci series is " + n1 + " " + n2);
		sd.append(" fibonacci series is : " +n1 + " ");
		sd.append(n2 + " ");
		for(int i=2 ; i <10 ; i++) {
			n3 = n1 +n2;
			System.out.print( " " +n3);
			n1 = n2;
			n2= n3;
			sd.append(n3 + " ");
		}
		return sd.toString();
	}
	
	public static String fibonacciSeriesWithRecursion() {
		int count =10;
		System.out.println("fibonacci series is "+"0" + " " + "1");
		DemoCodeExample.printFibonacci(count -1);
		return "";
	}
	
	private static void printFibonacci(int num) {
		if(num >0) {
			n3 = n1 +n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			printFibonacci(num-1);
		}
	}
	
	
}
