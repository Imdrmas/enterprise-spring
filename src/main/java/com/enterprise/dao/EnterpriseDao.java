package com.enterprise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.modal.Enterprise;

public interface EnterpriseDao extends JpaRepository<Enterprise, Long> {

}
