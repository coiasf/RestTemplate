package com.spring.main;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.model.Person;
import com.spring.main.PersonImplementation;
import com.spring.model.User;
import com.spring.model.City;
import com.spring.model.wrapper;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import com.spring.main.RestTemplateImplementation;

import java.util.Map;
import java.util.HashMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import com.spring.restLayer.Rest;


@RestController
public class HelloController {
	
	
	
	private final ArrayList<City> cities = new ArrayList<City>() {{
		add(new City("Rome",1,"0076765"));
    	add(new City("Venice",2,"0076765"));
    	add(new City("London",3,"0076765"));
    	add(new City("Bucharest",4,"0076765"));
    	add(new City("Berlin",5,"0076765"));		
	}};	
	
	private final ArrayList<User> users = new ArrayList<User>() {{
		add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	add(new User("Rome"));
    	add(new User("Venice"));
    	add(new User("London"));
    	add(new User("Bucharest"));
    	add(new User("Berlin"));
    	
    	
	}};	
	
	/* GET call that retrieves an User object. */
    @RequestMapping(value = "user/{id}",method = RequestMethod.GET, produces = "application/json")
    public User getUser(@PathVariable("id") Long id) {
    	User response = new User("Marcel",id);
        return response;
    }
    
    /* GET call that retrieves a list of cities. */
    @RequestMapping(value = "cities",method = RequestMethod.GET, produces = "application/json")
    public ArrayList<City> getCities() { 	    	
    	return (ArrayList<City>)this.cities;
    }
    
    /* GET call that makes a get request and retrieves and object of type User */
    @RequestMapping(value = "getUser",method = RequestMethod.GET, produces = "application/json")
    public wrapper<User> getUser() {
    	    	
    	Rest<User>  restApi =  new Rest<User>(null, null);	
    	ResponseWrapper<User> resp;	
		try {
			resp = restApi.get("http://localhost:8080/user/1",User.class);
			wrapper<User> wrap = new wrapper<User>("ceva cu date", resp.getResponse());			
			return wrap;
		} catch (Exception e) {
			//log the exception message in the console
			System.out.println(e.getMessage());			
			return null;
		}	
    }
    
    /* GET call that makes a get request and retrieves and ArrayList of objects of type User */
    @RequestMapping(value = "getcities",method = RequestMethod.GET, produces = "application/json")
    public wrapper<ArrayList<City>> getCitiesResp() {
    	
    	Rest<City>  restApi =  new Rest<City>(null, null);
    	ResponseWrapper<ArrayList> resp;
		try {
			resp = restApi.get("http://localhost:8080/cities",ArrayList.class);
			wrapper<ArrayList<City>> wrap = new wrapper<ArrayList<City>>("ceva cu date", resp.getResponse());
			return wrap;
		} catch (Exception e) {
			//log the exception message in the console
			System.out.println(e.getMessage());			
			return null;
		}
    }
    
    /* GET call that makes a post request that creates and then  retrieves and object of type User */
    @RequestMapping(value = "testPostUser",method = RequestMethod.GET, produces = "application/json")
    public wrapper<User> testUserPost() {
    		
    	User postUser = new User("IonutSaioc",3);
    	Rest<User>  restApi =  new Rest<User>(postUser, null);    	
    	ResponseWrapper<User> resp;
		try {
			resp = restApi.post("http://localhost:8080/postUser",User.class);
			wrapper<User> wrap = new wrapper<User>("ceva cu date", resp.getResponse());
			return wrap;
		} catch (Exception e) {
			//log the exception message in the console
			System.out.println(e.getMessage());			
			return null;
		}
    }
    
    @RequestMapping(value = "postUser",method = RequestMethod.POST, produces = "application/json")
    public User testUserPost(@RequestBody User user) {
    	User wrap = new User(user.getName(),user.getId());		
		return wrap;
    }    
    
    
    /* GET call that makes a post request that creates and then  retrieves and object of type User */
    @RequestMapping(value = "testPostCities",method = RequestMethod.GET, produces = "application/json")
    public wrapper<ArrayList<City>> testCitiesPost() {
    	Rest<ArrayList<City>>  restApi =  new Rest<ArrayList<City>>(this.cities, null);
    	ResponseWrapper<ArrayList> resp;
		try {
			resp = restApi.post("http://localhost:8080/postCities",ArrayList.class);
			wrapper<ArrayList<City>> wrap = new wrapper<ArrayList<City>>("ceva cu date", resp.getResponse());			
			return wrap;			
		} catch (Exception e) {
			//log the exception message in the console
			System.out.println(e.getMessage());			
			return null;
		}		
    }
    
    @RequestMapping(value = "postCities",method = RequestMethod.POST, produces = "application/json")
    public ArrayList<City> testCityPost(@RequestBody ArrayList<City> cities) {
    	ArrayList<City> finalCities = new ArrayList<City>();
    	for (City city:cities) {
    		finalCities.add(city);    		
    	}
		return finalCities;
    }
    
    /* GET call that makes a post request that creates and then  retrieves and object of type User */
    @RequestMapping(value = "testThreadUsers",method = RequestMethod.GET, produces = "application/json")
    public wrapper<ArrayList<User>> testThreadUsers() {
    	Rest<ArrayList<User>>  restApi =  new Rest<ArrayList<User>>(this.users, null);
    	ResponseWrapper<ArrayList> resp;
		try {
			long start = System.currentTimeMillis();	    	
	    	long time = System.currentTimeMillis() - start;
	    	
			resp = restApi.post("http://localhost:8080/postThreadUser",ArrayList.class);
			wrapper<ArrayList<User>> wrap = new wrapper<ArrayList<User>>("ceva cu date", resp.getResponse());			
			return wrap;
		} catch (Exception e) {
			//log the exception message in the console
			System.out.println(e.getMessage());
			return null;
		}		
    }
    //@RequestBody ArrayList<User> users
    @RequestMapping(value = "postThreadUser",method = RequestMethod.POST, produces = "application/json")
    public ArrayList<User> testThreadUser(@RequestBody ArrayList<User> users) {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");    	
    	UserImplementation userBean = context.getBean(UserImplementation.class);
 
    	try {			
			long start = System.currentTimeMillis();
			//ArrayList<User> finalUsers = userBean.saveNormal(users);
			ArrayList<User> finalUsers = userBean.saveBulk(users);
			context.close();
			long time = System.currentTimeMillis() - start;
			System.out.println(time);
			return finalUsers;    			
		} catch (Exception e) {
			context.close();
			System.out.println(e.getMessage());			
			return null;
		}		
    }
}
