package com.corner.dap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.corner.dao.iface.IUsers;
import com.corner.entity.Users;

public class UsersDao extends BaseDao implements IUsers
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	@Override
	public Users findUserByName(String name)
	{
		// TODO Auto-generated method stub
		Users user=null;
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from users where username=?");
				pstmt.setString(1, name);
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					user=new Users();
					user.setUserid(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setPwd(rs.getString(3));
					user.setPhone(rs.getString(4));
					user.setMail(rs.getString(5));
					user.setIsfreezed(rs.getInt(6));
					user.setUserhead(rs.getString(7));
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close(con, pstmt, rs);
		}
		return user;
	}
	@Override
	public Users findUserByID(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addUser(Users user)
	{
		// TODO Auto-generated method stub
		int result=-1;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("insert into users values(?,?,?,?,?,?,?)");
				pstmt.setInt(1, 0);
				pstmt.setString(2, user.getUsername());
				pstmt.setString(3, user.getPwd());
				pstmt.setString(4, user.getPhone());
				pstmt.setString(5, user.getMail());
				pstmt.setInt(6, 0);
				pstmt.setString(7, user.getUserhead());
				
				result=pstmt.executeUpdate();
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			close(con, pstmt, rs);
		}
		
		if(result==1)
			return true;
		else
			return false;
	}
}
