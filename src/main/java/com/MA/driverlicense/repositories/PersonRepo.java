package com.MA.driverlicense.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MA.driverlicense.models.Person;



@Repository

public interface PersonRepo extends CrudRepository<Person, Long> {
	 List<Person> findAll();
	    
	    Optional<Person> findById(Long x);
	    
	    void deleteById(Long id);
	    
	    Person save(Person a);
}
