package com.enterprise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.modal.User;

public interface UserDao extends JpaRepository<User, Long>{

}
