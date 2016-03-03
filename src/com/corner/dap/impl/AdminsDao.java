package com.corner.dap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.corner.dao.iface.IAdmins;
import com.corner.entity.Admins;

public class AdminsDao extends BaseDao implements IAdmins
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	@Override
	public Admins findAdminByName(String name)
	{
		// TODO Auto-generated method stub
		Admins admin=null;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select adminid,adminname,adminpwd,adminlevel,isfreezed from admins where adminname=?");
				pstmt.setString(1, name);
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					admin=new Admins();
					admin.setAdminid(rs.getInt(1));
					admin.setAdminname(rs.getString(2));
					admin.setAdminpwd(rs.getString(3));
					admin.setAdminlevel(rs.getInt(4));
					admin.setIsfreezed(rs.getInt(5));
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
		return admin;
	}

}
