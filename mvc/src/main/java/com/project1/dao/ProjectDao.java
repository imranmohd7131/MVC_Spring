package com.project1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.project1.bean.User;

@Repository
public class ProjectDao {
	public boolean signup(String email,String name,String password) {
		User us=new User(email,name,password);
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("p1");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
		transaction.begin();
		manager.persist(us);
		transaction.commit();
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		public boolean login(String email,String password) {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("p1");
			EntityManager manager=factory.createEntityManager();
			try {
			User us=manager.find(User.class,email);
			if(us!=null && us.getPassword().equals(password)){
				return true;
			}else {
				return false;
			}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean verifyuser(String email,String username) {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("p1");
			EntityManager manager=factory.createEntityManager();
			try {
			User us=manager.find(User.class,email);
			if(us!=null && us.getName().equalsIgnoreCase(username)) {
				return true;
			}else {
				return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean updatePassword(String email,String password) {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("p1");
			EntityManager manager=factory.createEntityManager();
			EntityTransaction transaction=manager.getTransaction();
			try {
			User us=manager.find(User.class, email);
		    us.setPassword(password);
		    transaction.begin();
		    manager.persist(us);
		    transaction.commit();
		    return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;	
			}
		}
}
