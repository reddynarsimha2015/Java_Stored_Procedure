 /**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.sreenutech;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author YNBR 05-Apr-2022
 *
 */
public class CallableStatementDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		String spQuery = "{call AUTO_BILL_PAYMTS_01(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		CallableStatement stmt = con.prepareCall(spQuery);

		// bind the values to the parameter

		stmt.setString(1, "web");
		stmt.setString(2, "23232323232");
		stmt.setString(3, "123");
		stmt.setString(4, "sreenu");
		stmt.setString(5, "12/2022");
		stmt.setString(6, "9966345671");
		stmt.setString(7, "02-APR-2022");
		stmt.setString(8, "22-APR-2022");
		stmt.setString(9, "500");
		stmt.setString(10, "O2");

		// register outparams

		stmt.registerOutParameter(11, java.sql.Types.VARCHAR);
		stmt.registerOutParameter(12, java.sql.Types.VARCHAR);
		stmt.registerOutParameter(13, java.sql.Types.VARCHAR);
		
		System.out.println("Executing stored procedure");
		
		stmt.execute();
		
		String ackNum = stmt.getString(11);
		String respCode = stmt.getString(12);
		String respMsg = stmt.getString(13);
		
		System.out.println("ackNum :"+ackNum+","+"respCode :"+respCode+","+"respMsg :"+respMsg);

	}
}
