package com.ibm.bluemix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.Set;

import javax.naming.*;
import javax.sql.DataSource;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DBConnection {
	
	
	
	public static Connection returnSqlConnection() throws ClassNotFoundException, SQLException, NamingException {
		
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		String serviceName = null;
		String jdbcClassName = "com.ibm.db2.jcc.DB2Driver";
		Connection connection = null;
		String user=null;
		String password=null; 
		String url=null;
		
		Class.forName(jdbcClassName);
		
		if (VCAP_SERVICES != null) {

			// parse the VCAP JSON structure
			JsonObject obj =  (JsonObject) new JsonParser().parse(VCAP_SERVICES);
			Entry<String, JsonElement> dbEntry = null;
			Set<Entry<String, JsonElement>> entries = obj.entrySet();
			// Look for the VCAP key that holds the sql db information
			for (Entry<String, JsonElement> eachEntry : entries) {				
				if (eachEntry.getKey().equals("sqldb")) {
					dbEntry = eachEntry;
					break;
				}
			}
			if (dbEntry == null) {			
				throw new RuntimeException("Could not find SQLDB key in VCAP_SERVICES env variable");    					
			}

			obj =(JsonObject) ((JsonArray)dbEntry.getValue()).get(0);		
			serviceName = (String)dbEntry.getKey();
			System.out.println("Service Name - "+serviceName);

			obj = (JsonObject) obj.get("credentials");

			user = obj.get("username").getAsString();
			password = obj.get("password").getAsString();
			url = obj.get("jdbcurl").getAsString();
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Got connection from VCAP_SERVICES");
		}else
		{
			// Read an external datasource to be defined in server.xml
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup("jdbc/sqldb");
				connection = ds.getConnection();
				System.out.println("Got connection from JNDI datasource");
			}
			catch (NamingException ex) {
				user = "fejqhjep";
				password = "qar9thytivol";
				url ="jdbc:db2://75.126.155.142:50000/I1459502";
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("Got connection from fixed url");
			}
			
			
			
		}
		
				
		
	    System.out.println("after getting connection");
//	    con.setAutoCommit(false);
	     
		return connection;
	}

	
	/*public static Connection returnSqlConnectionlocal() throws ClassNotFoundException, SQLException{


	    String  databaseUrl = "jdbc:db2://75.126.155.142:50000/I1459502";
	    Class.forName("com.ibm.db2.jcc.DB2Driver");

	    Connection con = DriverManager.getConnection(databaseUrl, "fejqhjep", "qar9thytivol");

	    System.out.println("test");
//	    con.setAutoCommit(false);

		return con;
	}*/

}