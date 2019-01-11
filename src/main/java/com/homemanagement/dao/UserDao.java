/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homemanagement.dao;

import com.homemanagement.dao.entity.User;

/**
 *
 * @author rr
 */
public interface UserDao {
    
    public User getUserById(Long id);
    
    public User getByUserName(String userName);
    
    public User getByEmail(String email);
    
    public Boolean validateUser(User user);
    
    public void registerUser(User user);
}
