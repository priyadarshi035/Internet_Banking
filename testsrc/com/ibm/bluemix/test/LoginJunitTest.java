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

public class LoginJunitTest {

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
	public void testLoginCheck() throws Exception{
		//fail("Not yet implemented");
		Credential crdntl = new Credential();
		crdntl.setUsername("demo");
		crdntl.setPassword("demo");		
	
		HttpClient httpClient = new HttpClient();
		Gson gson = new Gson();
        String requestJson = gson.toJson(crdntl);
        
        StringRequestEntity requestEntity = new StringRequestEntity(
        		requestJson,
        	    "application/json",
        	    "UTF-8");
        
        
        PostMethod post = new PostMethod("http://genericbankui.mybluemix.net/api/LoginCheck");
        post.setRequestEntity(requestEntity);
        assertEquals(200, httpClient.executeMethod(post));
        System.out.println("JUnit Completed Successfully");
	}

}
