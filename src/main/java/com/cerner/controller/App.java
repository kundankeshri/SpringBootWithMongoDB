package com.cerner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cerner.model.Test;
import com.cerner.model.User;
import com.cerner.service.AppService;

@RestController

public class App 
{
	@Autowired private AppService appService;
	@Autowired private MongoTemplate mongoTemplate;
	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/test")
	List<String> test() {
		return appService.checkLemda() ;
	}
	
	@RequestMapping("/userDetails")
	public List<User> getAllUsers() {
		return appService.getAllUsers();
	}
	
	@RequestMapping("/getUserById")
	public User getUserById() {
		return appService.getUserById("1.0");
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void addNewUsers(@RequestBody User user) {
		appService.save(user);
	}
	
	@RequestMapping(value = "/BasicQueryOperation", method = RequestMethod.GET)
	public Test basicQueryOperation() {
		return appService.basicQueryOperation();
	}
	
	@RequestMapping(value = "/findOneQuery", method = RequestMethod.GET)
	public Test findOne() {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("dog").and("age").is(40));	
		return  mongoTemplate.findOne(query, Test.class); 
	}
	
	@RequestMapping(value = "/listOfDocument", method = RequestMethod.GET)
	public List<Test> listOfDocument() {
		List<Integer> listOfAge = new ArrayList<Integer>();
		listOfAge.add(10);
		listOfAge.add(30);
		listOfAge.add(40);
		Query query = new Query();
		query.addCriteria(Criteria.where("age").in(listOfAge));	
		return  mongoTemplate.find(query, Test.class); 
	}
	
	@RequestMapping(value = "/lessThenGreateThen", method = RequestMethod.GET)
	public List<Test> lessThenGreateThen() {
		Query query = new Query();
		query.addCriteria(Criteria.where("age").exists(true)
				.andOperator(Criteria.where("age").gt(10),
						Criteria.where("age").lt(40)));
		return  mongoTemplate.find(query, Test.class); 
	}
	
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	public List<Test> sort() {
		Query query = new Query();
		query.addCriteria(Criteria.where("age").gte(30));
		query.with(new Sort(Sort.Direction.DESC,"age"));
		return  mongoTemplate.find(query, Test.class); 
	}
}
