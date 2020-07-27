package com.glaucus.graph.demo.service;

import java.util.List;

import com.glaucus.graph.demo.model.Person;

public interface PersonService {

	List<Person> findAll();
	void save(Person person);
	void update(Person person);
	void delete(String fullName);
	void connect(List<Person> persons);
    
}
