/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homemanagement.service;

import com.homemanagement.dao.EmployeeDao;
import com.homemanagement.dao.entity.Employee;
import com.homemanagement.pojo.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rr
 */
@Service
public class SampleService {
    @Autowired
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
    
    public void saveEmployeeDetails(EmployeeResponse empResponse){
        employeeDao.save(new Employee(empResponse));
    }
}
