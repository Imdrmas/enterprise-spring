package com.enterprise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.modal.Application;

public interface ApplicationDao extends JpaRepository<Application, Long>{

}
