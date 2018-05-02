package com.cerner.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cerner.dao.QueryRepository;
import com.cerner.dao.UserRepository;
import com.cerner.model.Test;
import com.cerner.model.User;
import com.cerner.service.AppService;
@EnableMongoRepositories(basePackages = "com.cerner.dao") 
@Service
@Transactional 
public class AppServiceImpl implements AppService {
	@Autowired private  UserRepository userRepository;
	@Autowired private QueryRepository queryRepository;

	public List<String> checkLemda() {
		List<String> stringList = new ArrayList<String>();
        stringList.add("ank");
        stringList.add("sam");
        stringList.add("az");
        stringList.add("neh");
        stringList.add("ad");
        stringList.stream().filter((s) -> s.startsWith("a"));
        return stringList;       
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	

	@Override
	public User getUserById(String UserId) {
		return userRepository.getUserById(UserId);	
	}

	@Override
	public void save(User user) {
	  userRepository.save(user);	
	}

	@Override
	public Test basicQueryOperation() {
		// TODO Auto-generated method stub
		return queryRepository.basicQueryOperation();
	}
	
	
	
}
