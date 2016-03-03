package com.corner.dap.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BaseDao
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	public Connection getConnection()
	{
	
		ResourceBundle bundle=ResourceBundle.getBundle("ConDB");
		String driver=bundle.getString("driver");
		String url=bundle.getString("url");
		String user=bundle.getString("user");
		String password=bundle.getString("password");	
		try
		{
			//System.out.println(driver);
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public void close(Connection con,Statement stmt,ResultSet rs)
	{
		try
		{
			if(con!=null)
			{
				con.close();
				con=null;
			}
			if(stmt!=null)
			{
				stmt.close();
				stmt=null;
			}
			if(rs!=null)
			{
				rs.close();
				rs=null;
				
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
