package com.enterprise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enterprise.modal.Enterprise;

@Service
public interface EnterpriseService {
	 
	 Enterprise createEnterprise(Enterprise enterprise);
	 
	 List<Enterprise> findEnterprises();
	 
	 Enterprise findEnterprise(long id);
	 
	 void deleteEnterprise(long id);
	  
	 int calculateJava(Enterprise enterprise);
	 
	 int calculateLow(Enterprise enterprise);
	 
	 int calculateMedium(Enterprise enterprise);
	 
	 int calculatePhp(Enterprise enterprise);
	 
	 int calculateHigh(Enterprise enterprise);
	 
	 int calculateJavascript(Enterprise enterprise);

}
