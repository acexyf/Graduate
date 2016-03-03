package com.corner.dap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.corner.dao.iface.IHouses;
import com.corner.entity.Houses;
import com.corner.entity.Locates;
import com.corner.entity.Users;

public class HousesDao extends BaseDao implements IHouses
{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	@Override
	public Houses findHouseById(int houseid)
	{
		// TODO Auto-generated method stub
		Houses house=null;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select h.*,u.*,l.* from houses h,users u,locates l where h.houseid=? and h.userid=u.userid and h.region=l.locateid");
				pstmt.setInt(1, houseid);
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					Users user=new Users();
					user.setUserid(rs.getInt(20));
					user.setUsername(rs.getString(21));
					user.setPwd(rs.getString(22));
					user.setPhone(rs.getString(23));
					user.setMail(rs.getString(24));
					user.setIsfreezed(rs.getInt(25));
					user.setUserhead(rs.getString(26));
					
					Locates locate=new Locates();
					locate.setLocateid(rs.getInt(27));
					locate.setLocatename(rs.getString(28));
					
					house=new Houses();
					house.setHouseid(rs.getInt(1));
					house.setTitle(rs.getString(2));
					house.setGenre(rs.getString(3));
					house.setWays(rs.getString(4));
					house.setResident(rs.getString(5));
					house.setRegion(locate);
					house.setLocations(rs.getString(7));
					house.setLayout(rs.getInt(8));
					house.setArea(rs.getInt(9));
					house.setDecorate(rs.getString(10));
					house.setOrient(rs.getString(11));
					house.setFloor(rs.getInt(12));
					house.setFloors(rs.getInt(13));
					house.setDepict(rs.getString(14));
					house.setRelease(rs.getTimestamp(15));
					house.setIspassed(rs.getInt(16));
					house.setPrice(rs.getInt(17));
					house.setImage(rs.getString(18));
					house.setUserid(user);
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
		
		return house;
	}

	@Override
	public ArrayList<Houses> findAllHouse()
	{
		// TODO Auto-generated method stub
		ArrayList<Houses> lists=new ArrayList<Houses>();
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select h.*,u.*,l.* from houses h,users u,locates l where h.userid=u.userid and h.region=l.locateid");
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					Users user=new Users();
					user.setUserid(rs.getInt(20));
					user.setUsername(rs.getString(21));
					user.setPwd(rs.getString(22));
					user.setPhone(rs.getString(23));
					user.setMail(rs.getString(24));
					user.setIsfreezed(rs.getInt(25));
					user.setUserhead(rs.getString(26));
					
					Locates locate=new Locates();
					locate.setLocateid(rs.getInt(27));
					locate.setLocatename(rs.getString(28));
					
					Houses house=new Houses();
					house.setHouseid(rs.getInt(1));
					house.setTitle(rs.getString(2));
					house.setGenre(rs.getString(3));
					house.setWays(rs.getString(4));
					house.setResident(rs.getString(5));
					house.setRegion(locate);
					house.setLocations(rs.getString(7));
					house.setLayout(rs.getInt(8));
					house.setArea(rs.getInt(9));
					house.setDecorate(rs.getString(10));
					house.setOrient(rs.getString(11));
					house.setFloor(rs.getInt(12));
					house.setFloors(rs.getInt(13));
					house.setDepict(rs.getString(14));
					house.setRelease(rs.getTimestamp(15));
					house.setIspassed(rs.getInt(16));
					house.setPrice(rs.getInt(17));
					house.setImage(rs.getString(18));
					house.setUserid(user);
					lists.add(house);
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
	
	@Override
	public int findNumberFollow(String condition)
	{
		// TODO Auto-generated method stub
		int number=-1;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement(condition);
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					number=rs.getInt(1);
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
		
		return number;
	}
	
	@Override
	public ArrayList<Houses> findHouseFollow(String condition)
	{
		// TODO Auto-generated method stub
		ArrayList<Houses> lists=new ArrayList<Houses>();
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement(condition);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					Users user=new Users();
					user.setUserid(rs.getInt(20));
					user.setUsername(rs.getString(21));
					user.setPwd(rs.getString(22));
					user.setPhone(rs.getString(23));
					user.setMail(rs.getString(24));
					user.setIsfreezed(rs.getInt(25));
					user.setUserhead(rs.getString(26));
					
					Locates locate=new Locates();
					locate.setLocateid(rs.getInt(6));
					locate.setLocatename(rs.getString(7));
					
					Houses house=new Houses();
					house.setHouseid(rs.getInt(1));
					house.setTitle(rs.getString(2));
					house.setGenre(rs.getString(3));
					house.setWays(rs.getString(4));
					house.setResident(rs.getString(5));
					house.setRegion(locate);
					house.setLocations(rs.getString(8));
					house.setLayout(rs.getInt(9));
					house.setArea(rs.getInt(10));
					house.setDecorate(rs.getString(11));
					house.setOrient(rs.getString(12));
					house.setFloor(rs.getInt(13));
					house.setFloors(rs.getInt(14));
					house.setDepict(rs.getString(15));
					house.setRelease(rs.getTimestamp(16));
					house.setIspassed(rs.getInt(17));
					house.setPrice(rs.getInt(18));
					house.setImage(rs.getString(19));
					house.setUserid(user);
					lists.add(house);
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

	@Override
	public boolean addHouses(Houses houses)
	{
		// TODO Auto-generated method stub
		int result=-1;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("insert into houses values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'yyyymmdd'),?,?,?,?)");
				pstmt.setInt(1, 0);
				pstmt.setString(2, houses.getTitle());
				pstmt.setString(3, houses.getGenre());
				pstmt.setString(4, houses.getWays());
				pstmt.setString(5, houses.getResident());
				pstmt.setInt(6, houses.getRegion().getLocateid());
				pstmt.setString(7, houses.getLocations());
				pstmt.setInt(8, houses.getLayout());
				pstmt.setInt(9, houses.getArea());
				pstmt.setString(10, houses.getDecorate());
				pstmt.setString(11, houses.getOrient());
				pstmt.setInt(12, houses.getFloor());
				pstmt.setInt(13, houses.getFloors());
				pstmt.setString(14, houses.getDepict());
				
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
				
				pstmt.setString(15, dateFormat.format(houses.getRelease().getTime()));
				pstmt.setInt(16, houses.getIspassed());
				pstmt.setInt(17, houses.getPrice());
				pstmt.setString(18, houses.getImage());
				pstmt.setInt(19, houses.getUserid().getUserid());
				
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


	
//	public static void main(String[] args)
//	{
//		HousesDao dao=new HousesDao();
//		Locates l=new Locates(101, "姑苏");
//		Users users=new Users(1001, "ace", "360e2ece07507675dced80ba867d6dcd", "13916302654", "ace@qq.com", 0, "");
//		GregorianCalendar calendar=new GregorianCalendar();
//		Timestamp timestamp=new Timestamp(calendar.getTimeInMillis());
//		Houses houses=new Houses(0, "彩香一村1单元合租", "别墅", "合租", "彩香一村", l, "彩香街道", 322, 150, "豪华装修", "南", "2/3", "", timestamp, 0, 2000, "", users);
//		dao.addHouses(houses);
//	}

}
