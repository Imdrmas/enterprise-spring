package com.enterprise.service;

import java.util.List;

import com.enterprise.modal.User;

public interface UserService {
   User createUser(User user);
   
   List<User> findUsers(); 
}
