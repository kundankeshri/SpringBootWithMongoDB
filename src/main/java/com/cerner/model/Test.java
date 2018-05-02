package com.cerner.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class Test {
private String ic ;
private String name;
public String getIc() {
	return ic;
}
public void setIc(String ic) {
	this.ic = ic;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
private int age ;
}
