package com.ibm.bluemix;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;

@Path("/LoginCheck")
public class BankUiController {

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
//	@Path("/Dat")
	public Response loginCheck(Credential crdntl){
		
		BankDao dao=new BankDao();
		boolean bool = false;
		
		//String username = crdntl.getUsername();
		//String password = crdntl.getPassword();
		String username = "demo";
		String password = "demo";
		JsonObject resultObject = new JsonObject();
		
		bool=true;
		//dao.chkLogin(username,password);
		
		if(bool)
		{
			resultObject.addProperty("loginStatus", "success");
			System.out.println("Login Successful");
		}else
		{
			resultObject.addProperty("loginStatus", "failed");
			System.out.println("Login failed...");
		}

		return Response.ok()
	            .entity(resultObject.toString())
	            .build();
	}
	

}
