package com.spring.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.model.Person;
import com.spring.model.User;

public class UserImplementation {
	
	private static SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public UserImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void save(User u) {
		//Session session = UserImplementation.sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		//session.persist(u);
		//tx.commit();
		//session.close();	
	}
	
	public ArrayList<User> insGetPers(User p){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		
		
		List<User> userList =  session.createCriteria(User.class).list();
		session.close();
		return (ArrayList<User>) userList;
		
	}
	
	public ArrayList<User> saveNormal(ArrayList<User> users) {
		Session session = UserImplementation.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Iterator<User> userIterator = users.iterator();
		while (userIterator.hasNext()) {
			User user = userIterator.next();
			session.save(user);					
		}
		tx.commit();
		session.close();
		return this.getAllUsers();
	}
	
	public ArrayList<User> saveBulk(ArrayList<User> users) {
		
		BlockingQueue<User> userQueue = new ArrayBlockingQueue<User>(users.size());
		ArrayList<User> finalUsers  = new ArrayList<User>();
		ArrayList<Thread> finalThread  = new ArrayList<Thread>();
		
		Thread getterThread  = new Thread(new Runnable(){
			public void run(){
				try {
					while (!(Thread.currentThread().isInterrupted())) {
						User user = userQueue.take();
						finalUsers.add(user);
						System.out.println("Thread gets user " + user.toString() + "with index" + user.getId()  + "from stack");
						System.out.println("Queu size" + userQueue.size());
						System.out.println("--------------------------------------------------------");	
						//Thread.sleep(30);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Interrupted");
					Thread.currentThread().interrupt();
				}
			}
        });
		
		getterThread.start();
		
		Iterator<User> userIterator = users.iterator();
		while (userIterator.hasNext()) {
			User user = userIterator.next();
			Thread userThread  = new Thread(new Runnable(){
				public void run(){					
					Session session = UserImplementation.sessionFactory.openSession();
					Transaction tx = session.beginTransaction();	
					session.save(user);
					tx.commit();
					session.close();
					userQueue.add(user);
					System.out.println("Thread adds user " + user.toString() + "with index" + user.getId()+ " to stack");
					System.out.println("--------------------------------------------------------");
				}
	        });
			finalThread.add(userThread);			
			userThread.start();		
		}
		
		for (Thread t:finalThread) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			getterThread.join(1000);
			return finalUsers;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<User> getAllUsers() {
		Session session = UserImplementation.sessionFactory.openSession();
		List<User> userList =  session.createCriteria(User.class).list();
		session.close();
		return (ArrayList<User>) userList;
	}
}
