/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homemanagement.dao.imp;

import com.homemanagement.dao.EmployeeDao;
import com.homemanagement.dao.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rr
 */
@Repository
public class EmployeeDaoImp implements EmployeeDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly=false)
    @Override
    public void save(Employee employee) {
        Session session = this.sessionFactory.openSession();
        session.persist(employee);
        session.flush(); // user flush with persist 
        //save() not need to flush.
        System.out.println("Employee created " + employee);

    }    

    @Override
    public void saveUsingJpaEntityManager(Employee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
