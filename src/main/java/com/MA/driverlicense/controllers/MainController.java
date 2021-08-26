package com.MA.driverlicense.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MA.driverlicense.models.License;
import com.MA.driverlicense.models.Person;
import com.MA.driverlicense.services.LicenseService;
import com.MA.driverlicense.services.PersonService;

@Controller
public class MainController {
	 private final LicenseService licenseService;
	 private final PersonService personService;
	    public MainController(LicenseService licenseService, PersonService personService) {
	        this.licenseService = licenseService;
	        this.personService = personService;
	        
	
}
	    
	    @RequestMapping("/")
		public String index() {
			return "index.jsp";
		}
	    
	 // ======================================================================
	//  MAIN PAGE
	// ======================================================================
		
	    @RequestMapping("/allLicenses")
	    public String index(Model model) {
	        List<License> licenses = licenseService.allLicenses();
	        model.addAttribute("licenses", licenses);
	        
	        return "licenses/allLicense.jsp";
	        
	  
	    }
	    
	    @RequestMapping("/licenses/new")
	    public String newLicense(Model model, @ModelAttribute("license") License license) {
	    	model.addAttribute("license", new License());
	    	model.addAttribute("persons", personService.allPersons());
	    
	        return "/licenses/newLicense.jsp";
	    }
	    
	    @RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/licenses/newLicense.jsp";
	        } else {
	        	licenseService.createLicense(license);
	            return "redirect:/allLicenses";
	        }
	    }

	    
	    // for person //
	    
	    @RequestMapping("/new/person")
	    public String newPerson(Model model) {
	    	model.addAttribute("person", new Person());
	        return "/licenses/person.jsp";
	    }
	    
	    @RequestMapping(value="/new/person", method=RequestMethod.POST)
	    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/licenses/person.jsp";
	        } else {
	            personService.createPerson(person);
	            return "redirect:/licenses/new";
	        }
	    }
	    
	    // to fix the error of the redirect to the other page
	    @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        sdf.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    }
	    
	    // show one license holder
	    
	    @RequestMapping("/licenses/{id}/show")
	    public String showLicense(@PathVariable("id") Long id, Model model) {
	    	model.addAttribute("license", licenseService.findLicense(id));
	    	
	    	List<Person> persons = personService.allPersons();
	    	model.addAttribute("persons", persons);
	        return "/licenses/profile.jsp";
	    }
	   
}
