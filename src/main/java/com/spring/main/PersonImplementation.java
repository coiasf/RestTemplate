package com.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.spring.model.Person;
import com.spring.model.User;

public class PersonImplementation {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public PersonImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();	
	}
	
	public ArrayList<Person> insGetPers(Person p){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		
		
		
		List<Person> userList =  session.createCriteria(Person.class).list();
		session.close();
		return (ArrayList<Person>) userList;
		
	}


}
