package com.glaucus.graph.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaucus.graph.demo.model.Person;
import com.glaucus.graph.demo.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> findAll() {
		List<Person> result = new ArrayList<>();
		personRepository.findAll().forEach(result::add);
		return result;

	}

	@Override
	public void save(Person person) {
		person.setCreation(new Date());
		person.setLastModified(new Date());
		personRepository.save(person);
	}

	@Override
	public void update(Person person) {
		Person dbPerson = personRepository.findByFullName(person.getFullName());
		dbPerson.setEmail(person.getEmail());
		dbPerson.setPhoneNumber(person.getPhoneNumber());
		dbPerson.setLastModified(new Date());
		personRepository.save(dbPerson);
	}

	@Override
	public void delete(String fullName) {
		Person person = personRepository.findByFullName(fullName);
		personRepository.delete(person);

	}

	@Override
	public void connect(List<Person> persons) {
		Person person1 = personRepository.findByFullName(persons.get(0).getFullName());
		Person person2 = personRepository.findByFullName(persons.get(1).getFullName());
		person1.connectsWith(person2);
		personRepository.save(person1);

	}

}
