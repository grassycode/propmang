/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homemanagement.dao.imp;

import com.homemanagement.dao.UserDao;
import com.homemanagement.dao.entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where id =:id");
        query.setParameter("id", id);
        List<User> users = query.list();
        return users.get(0);
    }

    @Override
    public User getByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where userName =:userName");
        query.setParameter("userName", userName);
        List<User> users = query.list();
        return users.get(0);
    }

    @Override
    public User getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email =:email");
        query.setParameter("email", email);
        List<User> users = query.list();
        return users.get(0);
    }

    @Override
    public Boolean validateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where (userName=:userName or email=: email) and password=:password");
        query.setParameter("userName", user.getUserName());
        query.setParameter("email", user.getEmail());
        query.setParameter("password", user.getPassword());
        List<User> users = query.list();
        if(users != null && users.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public void registerUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        session.persist(user);
        tx.commit();
    }

}
    