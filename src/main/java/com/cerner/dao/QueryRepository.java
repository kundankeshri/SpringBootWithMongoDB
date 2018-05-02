package com.cerner.dao;

import org.springframework.stereotype.Repository;

import com.cerner.model.Test;

@Repository
public interface QueryRepository {
  Test basicQueryOperation();
}
