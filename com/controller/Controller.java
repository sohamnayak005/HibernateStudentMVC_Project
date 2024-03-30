package com.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.model.Student;

public class Controller {
	
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		 EntityManager em=emf.createEntityManager();
		 EntityTransaction et=em.getTransaction();
		 
		 public void studentSave(Student s) {
			 et.begin();
			 em.persist(s);
			 et.commit();
		 }
		 public Student findById(int id) {
			 Student s=em.find(Student.class,id);
			 return s;
		 }
		 public boolean findIdByUpdate(int id,String email) {
		  Student s=findById(id);
		  if(s!=null) {
			  s.setEmail(email);
			  et.begin();
			  em.merge(s);
			  et.commit();
			  return true;
		  }
		  else {
			  return false;
		  }
		 }
		 
		 public boolean findIdByDelete(int id) {
			  Student s=findById(id);
			  if(s!=null) {
				  et.begin();
				  em.remove(s);
				  et.commit();
				  return true;
			  }
			  else {
				  return false;
			  }
			 }
}
