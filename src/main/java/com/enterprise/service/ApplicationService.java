package com.enterprise.service;

import java.util.List;

import com.enterprise.modal.Application;

public interface ApplicationService {
   Application createApplicationForUser(Application application, long id);
   
   Application createApplicationForEnterprise(long idApplication, long id);
   
   List<Application> findApplications();
   
   List<Application> findApplicationsForEnterprise(long id);
   
   Application findApplication(long id);
   
   void deleteApplication(long id);
}
