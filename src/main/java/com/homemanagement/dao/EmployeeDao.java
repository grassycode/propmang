/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homemanagement.dao;

import com.homemanagement.dao.entity.Employee;
import org.springframework.stereotype.Component;

/**
 *
 * @author rr
 */
@Component
public interface EmployeeDao {
    
    public void save(Employee e);
    public void saveUsingJpaEntityManager(Employee e);
    
}
