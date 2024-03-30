package com.controller;

import javax.persistence.Query;
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
		 public boolean findIdByUpdate(int id,String gender) {
		  Student s=findById(id);
		  if(s!=null) {
			  s.setGender(gender);
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
		 
		 public Query fetchAllStudent() {
			 Query q=em.createQuery("select s from Student s");
			 //System.out.println(q.getResultList());
			 return q;
		 }
}
