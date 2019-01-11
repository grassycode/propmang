package com.homemanagement.pojo;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
//@XmlRootElement(name = "sampleclass")
@JsonInclude(content = Include.NON_NULL)
public class SampleClass {
	
	private String test1;
	
	/**
	 * @param test1
	 */
	public SampleClass(String test1) {
		super();
		this.test1 = test1;
	}

	/**
	 * 
	 */
	public SampleClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the test1
	 */
	public String getTest1() {
		return test1;
	}

	/**
	 * @param test1 the test1 to set
	 */
	public void setTest1(String test1) {
		this.test1 = test1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SampleClass [" + (test1 != null ? "test1=" + test1 : "") + "]";
	}
	
	
	
}
