package com.glaucus.graph.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glaucus.graph.demo.model.Person;
import com.glaucus.graph.demo.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
	public void listPeople(HttpServletResponse response) throws IOException {
		response.sendRedirect("/people/");
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST, consumes = "application/json")
	@Transactional
	public void addPerson(@RequestBody Person person, HttpServletResponse response) throws IOException {
		personService.save(person);
		response.sendRedirect("/people/");
	}

	@RequestMapping(value = "/updatePerson", method = RequestMethod.POST, consumes = "application/json")
	@Transactional
	public void updatePerson(@RequestBody Person person, HttpServletResponse response) throws IOException {
		personService.update(person);
		response.sendRedirect("/people/");
	}

	@RequestMapping(value = "/deletePerson", method = RequestMethod.POST, consumes = "application/json")
	@Transactional
	public void deletePerson(@RequestBody Person person, HttpServletResponse response) throws IOException {
		personService.delete(person.getFullName());
		response.sendRedirect("/people/");
	}

	@RequestMapping(value = "/connectPersons", method = RequestMethod.POST, consumes = "application/json")
	@Transactional
	public void connectPersons(@RequestBody List<Person> persons, HttpServletResponse response) throws IOException {
		personService.connect(persons);
		response.sendRedirect("/people/");
	}

}