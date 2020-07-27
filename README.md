# glaucusAssignment

Start Neo4j DB from issuing following command :
neo4j-community-3.5.20-windows\neo4j-community-3.5.20\bin$neo4j console

API End Points :

List All Persons
GET
http://localhost:8080/persons

Create a new Person
POST
http://localhost:8080/addPerson
Request Body :
{"fullName" : "PK","email" : "test@gmail.com","phoneNumber":"9876543210"}

Update a new Person
POST
http://localhost:8080/updatePerson
Request Body :
{"fullName" : "PK","email" : "test@gmail.com","phoneNumber":"9876543211"}

Delete a Person
POST
http://localhost:8080/deletePerson
Request Body :
{"fullName":"PK"}


Create connection between 2 persons.
POST
http://localhost:8080/connectPersons
Request Body:
[{"fullName" : "PK","email" : "test@gmail.com","phoneNumber":"9876543211"},{"fullName" : "MK","email" : "test2@gmail.com","phoneNumber":"9876543211"}]
