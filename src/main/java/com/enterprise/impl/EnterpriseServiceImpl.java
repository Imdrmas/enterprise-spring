package com.enterprise.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.enterprise.calculator.CalculateHigh;
import com.enterprise.calculator.CalculateMedium;
import com.enterprise.calculator.CalculateJava;
import com.enterprise.calculator.CalculateJavascript;
import com.enterprise.calculator.CalculateLow;
import com.enterprise.calculator.CalculatePhp;
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
	public int calculateJava(Enterprise enterprise) {
		CalculateJava calculateJava = new CalculateJava();
		enterprise.accept(calculateJava);
		return calculateJava.getValue();
	}

	@Override
	public int calculateLow(Enterprise enterprise) {
		CalculateLow calculateLow = new CalculateLow();
		enterprise.accept(calculateLow);
		return calculateLow.getValue();
	}

	@Override
	public int calculateMedium(Enterprise enterprise) {
		CalculateMedium calculateMedium = new CalculateMedium();
		enterprise.accept(calculateMedium);
		return calculateMedium.getValue();
	}

	@Override
	public int calculatePhp(Enterprise enterprise) {
		CalculatePhp calculatePhpApps = new CalculatePhp();
		enterprise.accept(calculatePhpApps);
		return calculatePhpApps.getValue();
	}

	@Override
	public int calculateJavascript(Enterprise enterprise) {
		CalculateJavascript calculateJavascript = new CalculateJavascript();
		enterprise.accept(calculateJavascript);
		return calculateJavascript.getValue();
	}

	@Override
	public int calculateHigh(Enterprise enterprise) {
		CalculateHigh calculateHigh = new CalculateHigh();
		enterprise.accept(calculateHigh);
		return calculateHigh.getValue();
	}


}
