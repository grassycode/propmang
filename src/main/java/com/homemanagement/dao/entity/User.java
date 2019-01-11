/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homemanagement.dao.entity;

import com.homemanagement.pojo.UserResponse;
import com.homemanagement.utils.PropertyType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rr
 */
@Entity
@Table(name = "user") //Serializable 
public class User implements Serializable {
    
    private static User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

@Column(name = "name")
    private String userName;

    private String password;
    private String email;
    private String question;
    private String answer;
    private PropertyType type;

    public User() {
    }
    
    public User(UserResponse userResponse) {
        this.userName = userResponse.getUserName();
        this.email = userResponse.getUserName();
        this.password = userResponse.getPassword();
        this.type = userResponse.getType();
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        User.user = user;
    }
    
    public static User getInstance() {
        return getInstance(false);
    }
    
    public static User getInstance(Boolean newFlag) {
        if (!newFlag && user != null){
            return user;
        }
        else {
            return new User();
        }
    }
}
