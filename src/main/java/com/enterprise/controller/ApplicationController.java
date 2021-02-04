package com.enterprise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.modal.Application;
import com.enterprise.service.ApplicationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/createApplication/{id}")
	Application createApplication(@RequestBody Application application, @PathVariable long id) {
		return applicationService.createApplicationForUser(application, id);
	}
	@PostMapping("/createApplicationForEnterprise/{id}")
	Application createApplicationForEnterprise(@RequestBody Application application, @PathVariable long id) {
		return applicationService.createApplicationForEnterprise(application, id);
	}
	   
	@GetMapping("/findApplications/{id}")
	List<Application> findApplications(@PathVariable long id) {
		return findApplications(id);
	}

	@GetMapping("/findApplication/{id}")
	Application findApplication(@PathVariable long id) {
		return findApplication(id);
	}

	@DeleteMapping("/deleteApplication/{id}")
	void deleteApplication(@PathVariable long id) {
		applicationService.deleteApplication(id);
	}
}
