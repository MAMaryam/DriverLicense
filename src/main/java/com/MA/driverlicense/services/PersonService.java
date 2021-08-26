package com.MA.driverlicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MA.driverlicense.models.Person;
import com.MA.driverlicense.repositories.PersonRepo;



@Service
public class PersonService {
	private final PersonRepo personRepo;
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    } 
    // returns all the authors
    public List<Person> allPersons() {
        return personRepo.findAll();
    }
    
    // saves a author (either to update or create new)
    public Person createPerson(Person a) {
        return personRepo.save(a);
    }
    
    // retrieves a author
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepo.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
    
    // delete author
    public void deleteAuthor(Long id) {
    	personRepo.deleteById(id);
    }
}