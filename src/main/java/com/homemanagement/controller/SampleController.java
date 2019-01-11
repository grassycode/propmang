package com.homemanagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import POJO.SampleClass;
import POJO.SampleUnit;
import com.homemanagement.pojo.EmployeeResponse;
import com.homemanagement.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value = "/test1")
public class SampleController {

    @Autowired
    private SampleService sampleService;
    
        @RequestMapping(value="/saveemployee", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public HttpServletResponse saveEmployee(
                @RequestBody EmployeeResponse empResponse,
                HttpServletRequest request,
                HttpServletResponse response) {
            System.out.println("save employee");
            sampleService.saveEmployeeDetails(empResponse);
            response.setStatus(200);
            return response;
	}
    
	@RequestMapping(value = "/test2",method = RequestMethod.GET)
	public String getRequestForTest(HttpServletRequest request) {
		System.out.println("test2");
                System.out.println("session" + request.getSession());
		return "views/index";
	}
	
	@RequestMapping(value = "/givejson",method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SampleUnit returnsJsonResponse() {
		System.out.println("test2");
		SampleClass sampleClass = new SampleClass("inside Json body");
		List<SampleClass> listOfClass = new ArrayList<>();
		listOfClass.add(sampleClass);
		SampleUnit sampleUnit = new SampleUnit("ranjan","21","apartment", null, listOfClass);
		return sampleUnit;
	}
	
	@RequestMapping(value="/jsonconsume", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String byConsumes(@RequestBody SampleUnit unit) {
		return "Consumed (POJO '" + unit + "')";
	}
	
	@RequestMapping(value="/request", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String requestResponse(@RequestBody SampleUnit unit, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getContextPath());
		System.out.println(request.getSession());
		response.setStatus(300, "accepted");
		return "Consumed (POJO '" + unit + "')";
	}

    public void setSampleService(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    public SampleService getSampleService() {
        return sampleService;
    }
    
}
