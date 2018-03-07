package com.ibm.bluemix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.ibm.bluemix.DBConnection;

public class BankDao {


public boolean chkLogin(String userName, String passWord) {
	//boolean bool=false;
	boolean bool=true;
	PreparedStatement pst=null;
	Connection con=null;
	
	userName = "demo";
	passWord = "demo";
	
//
//		try {
//			con = DBConnection.returnSqlConnection();
//			System.out.println("inside chkLogin");
//
//			/*//SQL DB 
//			String qry="SELECT * FROM ARPANROY_IN_IBM_COM.USER WHERE username=? and password=?";
//			*/
//			//dash db 
//			String qry="SELECT * FROM dash6011.USER WHERE username=? and password=?";
//			
//			pst= (PreparedStatement) con.prepareStatement(qry);
//			//pst.setString(1, userName);
//			//pst.setString(2, passWord);
//			
//			
//			pst.setString(1, "demo");
//			pst.setString(2, "demo");
//			
//			ResultSet rs = (ResultSet)pst.executeQuery();
//			int colm=rs.getMetaData().getColumnCount();
//			if(rs.next()){
//				bool=true;
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch(NamingException ex){
//			ex.printStackTrace();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		/*finally{
//			try {
//				pst.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}*/


	return bool;
}
}