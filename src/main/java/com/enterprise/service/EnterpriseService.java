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
	  
	 int calculateJavaApps(Enterprise enterprise);
	 
	 int calculateLowApps(Enterprise enterprise);
	 
	 int calculateLowAndJava(Enterprise enterprise);
	 
	 int calculatePhpApps(Enterprise enterprise);
	 
	 int calculateHighApps(Enterprise enterprise);
	 
	 int calculateHigtAndPhp(Enterprise enterprise);

}
