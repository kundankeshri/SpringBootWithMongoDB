package com.cerner.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cerner.model.Test;
import com.cerner.model.User;

@Repository
public interface UserRepository {
  List<User> getAllUsers();
  User getUserById(String userId);
  void save(User user);
}
