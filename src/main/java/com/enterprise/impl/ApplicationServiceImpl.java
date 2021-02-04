package com.enterprise.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.dao.ApplicationDao;
import com.enterprise.dao.EnterpriseDao;
import com.enterprise.dao.UserDao;
import com.enterprise.modal.Application;
import com.enterprise.modal.Enterprise;
import com.enterprise.modal.User;
import com.enterprise.service.ApplicationService;

@Transactional
@Component
public class ApplicationServiceImpl implements ApplicationService{
 
	@Autowired
	private ApplicationDao applicationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EnterpriseDao enterpriseDao;

	@Override
	public Application createApplicationForUser(Application application, long id) {
		User user = userDao.findById(id).orElse(null);
		application.setUser(user);
		return applicationDao.save(application);
	}

	@Override
	public List<Application> findApplications(long id) {
		Enterprise enterprise = enterpriseDao.findById(id).orElse(null);
		return enterprise.getApplications();
	}

	@Override
	public Application findApplication(long id) {
		return applicationDao.findById(id).orElse(null);
	}

	@Override
	public void deleteApplication(long id) {
		applicationDao.deleteById(id);		
	}

	@Override
	public Application createApplicationForEnterprise(Application application, long id) {
		Enterprise enterprise = enterpriseDao.findById(id).orElse(null);
		enterprise.addApplication(application);
		return applicationDao.save(application);
	}
}
