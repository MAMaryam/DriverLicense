package com.MA.driverlicense.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MA.driverlicense.models.License;

@Repository

public interface LicenseRepo extends CrudRepository<License, Long> {
//	/ this method retrieves all the licenses from the database
    List<License> findAll();
    
    Optional<License>findById(Long x);
    // this method finds books with descriptions containing the search string
    List<License> findByStateContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByPersonContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByPersonStartingWith(String search);
    
    void deleteById(Long id);
    
    License save(License licensek);

}
