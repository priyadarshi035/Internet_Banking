package com.ibm.bluemix.test;

import static org.junit.Assert.*;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.ibm.bluemix.Credential;

public class TransferDetails {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TransferDetails() throws Exception{
		//fail("Not yet implemented");
		Credential crdntl = new Credential();
		crdntl.setUsername("demo");
		crdntl.setPassword("demo");		
	
		        System.out.println("TransferDetails Completed Successfully");
	}

}
