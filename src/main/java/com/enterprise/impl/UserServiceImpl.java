package com.enterprise.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.dao.UserDao;
import com.enterprise.modal.User;
import com.enterprise.service.UserService;

@Transactional
@Component
public class UserServiceImpl implements UserService{
 
	@Autowired
	private UserDao userDao;

	@Override
	public User createUser(User user) {
		return userDao.save(user);
	}

	@Override
	public List<User> findUsers() {
		return userDao.findAll();
	}
}
