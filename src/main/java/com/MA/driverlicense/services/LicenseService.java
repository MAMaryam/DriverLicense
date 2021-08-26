package com.MA.driverlicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MA.driverlicense.models.License;
import com.MA.driverlicense.repositories.LicenseRepo;


@Service
public class LicenseService {
	   
    private final LicenseRepo licenseRepo;
    public LicenseService(LicenseRepo licenseRepo) {
        this.licenseRepo = licenseRepo;
     
    } 
    // returns all the books
    public List<License> allLicenses() {
        return licenseRepo.findAll();
    }
    
 // saves a book (either to update or create new)
    public License createLicense(License L) {
        return licenseRepo.save(L);
    }
    
    // retrieves 
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepo.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }


}
