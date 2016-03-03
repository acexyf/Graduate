package com.corner.dao.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corner.dao.servlet.IModel;
import com.corner.dap.impl.HousesDao;
import com.corner.entity.Houses;

public class initHouse implements IModel
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		
		String houseid=request.getParameter("houseid");
		if(houseid==null)
		{
			return "WEB-INF/pages/error.jsp";
		}
		else
		{
			HousesDao dao=new HousesDao();
			Houses house=dao.findHouseById(Integer.parseInt(houseid));
			if(house==null)
			{
				return "WEB-INF/pages/error.jsp";
			}
			else
			{
				request.setAttribute("house", house);
				return "WEB-INF/pages/house.jsp";
			}
		}
	}

}
