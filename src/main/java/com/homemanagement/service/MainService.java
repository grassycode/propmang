/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homemanagement.service;

import com.homemanagement.dao.UserDao;
import com.homemanagement.dao.entity.User;
import com.homemanagement.pojo.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rr
 */
@Service
public class MainService {
    
    @Autowired
    private UserDao userDao;

    public void register(UserResponse userResponse) {
        userDao.registerUser(new User(userResponse));
    }

    public UserResponse login(UserResponse userResponse) {
        return userResponse;
    }
    
}
