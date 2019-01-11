/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homemanagement.controller;

import com.homemanagement.pojo.UserResponse;
import com.homemanagement.pojo.GenericResponse;
import com.homemanagement.service.MainService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rr
 */
@Controller
@RequestMapping(value = "/core")
public class MainController {

    @Autowired
    private MainService mainService;
    
    @Autowired
    private GenericResponse genericResponse;

    @RequestMapping(value = "/register",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private @ResponseBody
    GenericResponse registerUser(@RequestBody UserResponse user, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        GenericResponse genResponse = new GenericResponse();
        if (session.getAttribute("userName") != null) {
            genResponse.setCode(300);
            genResponse.setStatus("Already logged in: Close your brower and please try again.");
        }
        else {
            mainService.register(user);
            genResponse.setCode(200);
            genResponse.setStatus("User registered");

        }
        return genResponse;
    }
    
    //return home page or return json response
    @RequestMapping(value = "/login")
    private @ResponseBody GenericResponse login(@RequestBody UserResponse userResponse, HttpServletRequest request, HttpServletResponse reposen) {
        UserResponse validUser = mainService.login(userResponse);
        genericResponse.setCode(500);
        genericResponse.setStatus("Server error");
        genericResponse.setMessage("Error logged");
        return genericResponse;
    }

    public MainService getMainService() {
        return mainService;
    }

    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }

    public GenericResponse getGenericResponse() {
        return genericResponse;
    }

    public void setGenericResponse(GenericResponse genericResponse) {
        this.genericResponse = genericResponse;
    }
    
    
    

}
