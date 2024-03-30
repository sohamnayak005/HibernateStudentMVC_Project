package com.view;

import com.controller.Controller;
import com.model.Student;

public class View {
	static Controller con=new Controller();
  public static void main(String[] args) {
	Student s=new Student();
	// Insert
	s.setId(102);
	s.setName("Soham");
	s.setEmail("soham@gmail.com");
	s.setPassword("soha@56");
	s.setMob(123456789);
	s.setDob("11/12/23");
	con.studentSave(s);
	
	//Find By Id
	Student sf= con.findById(101);
	if(sf!=null) {
		System.out.println(sf.getId()+" "+sf.getName()+sf.getEmail()+" "+sf.getPassword()+" "+sf.getMob()+" "+sf.getDob());
	}
	else {
		System.out.println("Student not Found");
	}
	
	//Update by id
	
	boolean b=con.findIdByUpdate(101,"anita@gmail.com");
	if(b) {
		System.out.println("Record has been Updated");
	}
	else {
		System.out.println("Record not found");
	}
	
	//Delete by id
	
	boolean d=con.findIdByDelete(102);
	if(d) {
		System.out.println("Record has been Updated");
	}
	else {
		System.out.println("Record not found");
	}
}
}
