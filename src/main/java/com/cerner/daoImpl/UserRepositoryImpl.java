 package com.cerner.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cerner.dao.UserRepository;
import com.cerner.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		System.out.println(mongoTemplate.findAll(User.class));
		 return mongoTemplate.findAll(User.class);
	}
	
	@Override
	public User getUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is("5ae6da3f0659f6f8efdc96ff"));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public void save(User user) {
		 mongoTemplate.save(user);
	}


}
