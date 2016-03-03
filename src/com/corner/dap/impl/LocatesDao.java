package com.corner.dap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.corner.dao.iface.ILocates;
import com.corner.entity.Locates;

public class LocatesDao extends BaseDao implements ILocates
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	@Override
	public ArrayList<Locates> findAllRegion()
	{
		ArrayList<Locates> lists=new ArrayList<Locates>();
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from locates");
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					Locates loc=new Locates();
					loc.setLocateid(rs.getInt(1));
					loc.setLocatename(rs.getString(2));
					lists.add(loc);
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
		
		return lists;
	}
	
//	public static void main(String[] args)
//	{
//		LocatesDao locateDao=new LocatesDao();
//		ArrayList<Locates> lists=locateDao.findAllRegion();
//		for (Locates locates : lists)
//		{
//			System.out.println(locates.getLocatename());
//		}
//	}
}
