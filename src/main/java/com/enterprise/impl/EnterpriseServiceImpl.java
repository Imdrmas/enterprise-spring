package com.enterprise.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.enterprise.calculator.CalculateHighApps;
import com.enterprise.calculator.CalculateHigtAndPhp;
import com.enterprise.calculator.CalculateJavaApps;
import com.enterprise.calculator.CalculateLowAndJava;
import com.enterprise.calculator.CalculateLowApps;
import com.enterprise.calculator.CalculatePhpApps;
import com.enterprise.dao.EnterpriseDao;
import com.enterprise.modal.Enterprise;
import com.enterprise.service.EnterpriseService;

@Transactional
@Component
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	private EnterpriseDao enterpriseDao;

	@Override
	public Enterprise createEnterprise(Enterprise enterprise) {
		return enterpriseDao.save(enterprise);
	}

	@Override
	public List<Enterprise> findEnterprises() {
		return enterpriseDao.findAll();
	}

	@Override
	public Enterprise findEnterprise(long id) {
		return enterpriseDao.findById(id).orElse(null);
	}

	@Override
	public void deleteEnterprise(long id) {
		enterpriseDao.deleteById(id);	
	}

	@Override
	public int calculateJavaApps(Enterprise enterprise) {
		CalculateJavaApps calculateJavaApps = new CalculateJavaApps();
		enterprise.accept(calculateJavaApps);
		return calculateJavaApps.getValue();
	}

	@Override
	public int calculateLowApps(Enterprise enterprise) {
		CalculateLowApps calculateLowApps = new CalculateLowApps();
		enterprise.accept(calculateLowApps);
		return calculateLowApps.getValue();
	}

	@Override
	public int calculateLowAndJava(Enterprise enterprise) {
		CalculateLowAndJava calculateLowAndJava = new CalculateLowAndJava();
		enterprise.accept(calculateLowAndJava);
		return calculateLowAndJava.getValue();
	}

	@Override
	public int calculatePhpApps(Enterprise enterprise) {
		CalculatePhpApps calculatePhpApps = new CalculatePhpApps();
		enterprise.accept(calculatePhpApps);
		return calculatePhpApps.getValue();
	}

	@Override
	public int calculateHighApps(Enterprise enterprise) {
		CalculateHighApps calculateHighApps = new CalculateHighApps();
		enterprise.accept(calculateHighApps);
		return calculateHighApps.getValue();
	}

	@Override
	public int calculateHigtAndPhp(Enterprise enterprise) {
		CalculateHigtAndPhp calculateHigtAndPhp = new CalculateHigtAndPhp();
		enterprise.accept(calculateHigtAndPhp);
		return calculateHigtAndPhp.getValue();
	}


}
