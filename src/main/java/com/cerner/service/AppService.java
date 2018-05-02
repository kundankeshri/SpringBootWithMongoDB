package com.cerner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cerner.model.Test;
import com.cerner.model.User;
@Service
public interface AppService {
	List<String> checkLemda();
	List<User> getAllUsers();
	User getUserById(String UserId);
	void save(User user);
	Test basicQueryOperation();

}
