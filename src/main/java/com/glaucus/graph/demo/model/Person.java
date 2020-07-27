package com.glaucus.graph.demo.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	private String fullName;
	private String email;
	private Date creation;
	private Long phoneNumber;
	private Date lastModified;
	@Relationship(type = "CONNECTION", direction = Relationship.UNDIRECTED)
	public Set<Person> connections;

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Set<Person> getConnections() {
		return connections;
	}

	public void setConnections(Set<Person> connections) {
		this.connections = connections;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setLastName(String email) {
		this.email = email;
	}

	public void connectsWith(Person person) {
		if (connections == null) {
			connections = new HashSet<>();
		}
		connections.add(person);
	}

	public String toString() {

		return this.fullName + "'s connections => " + Optional.ofNullable(this.connections)
				.orElse(Collections.emptySet()).stream().map(Person::getFullName).collect(Collectors.toList());
	}
}
