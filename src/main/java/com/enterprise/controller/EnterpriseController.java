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

import com.enterprise.dao.EnterpriseDao;
import com.enterprise.modal.Enterprise;
import com.enterprise.service.EnterpriseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;

	@Autowired
	private EnterpriseDao enterpriseDao;

	@PostMapping("/createEnterprise")
	Enterprise createEnterprise(@RequestBody Enterprise enterprise) {
		return enterpriseService.createEnterprise(enterprise);
	}

	@GetMapping("/findEnterprises")
	List<Enterprise> findEnterprises() {
		return enterpriseService.findEnterprises();
	}
   
	@GetMapping("/findEnterprise/{id}")
	Enterprise findEnterprise(@PathVariable long id) {
		return enterpriseService.findEnterprise(id);
	}
    
	@DeleteMapping("/deleteEnterprise/{id}")
	void deleteEnterprise(@PathVariable long id) {
		enterpriseService.deleteEnterprise(id);
	}
    @GetMapping("/calculateJavaApps/{id}")
	int calculateJavaApps(@PathVariable long id) {
    	Enterprise enterprise = enterpriseDao.findById(id).get();
		return enterpriseService.calculateJavaApps(enterprise);
	}
    @GetMapping("/calculateLowApps/{id}")
	int calculateLowApps(@PathVariable long id) {
    	Enterprise enterprise = enterpriseDao.findById(id).get();
		return enterpriseService.calculateLowApps(enterprise);
	}
    @GetMapping("/calculateLowAndJava/{id}")
	int calculateLowAndJava(@PathVariable long id) {
    	Enterprise enterprise = enterpriseDao.findById(id).get();
		return enterpriseService.calculateLowAndJava(enterprise);
	}
    @GetMapping("/calculatePhpApps/{id}")
	int calculatePhpApps(@PathVariable long id) {
    	Enterprise enterprise = enterpriseDao.findById(id).get();
		return enterpriseService.calculatePhpApps(enterprise);
	}
    @GetMapping("/calculateHighApps")
	int calculateHighApps(@PathVariable long id) {
    	Enterprise enterprise = enterpriseDao.findById(id).get();
		return enterpriseService.calculateHighApps(enterprise);
	}
    @GetMapping("/calculateHigtAndPhp/{id}")
	int calculateHigtAndPhp(@PathVariable long id) {
    	Enterprise enterprise = enterpriseDao.findById(id).get();
		return enterpriseService.calculateHigtAndPhp(enterprise);
	}
}
