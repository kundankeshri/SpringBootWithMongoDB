package com.cerner.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cerner.dao.QueryRepository;
import com.cerner.model.Test;

@Repository
public class QueryRepositoryImpl implements QueryRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Test basicQueryOperation() {
		BasicQuery query1 = new BasicQuery("{ age : { $lt : 40 }, name : 'cat' }");
		Test query =  mongoTemplate.findOne(query1, Test.class);
		return query;
	}

	
}
