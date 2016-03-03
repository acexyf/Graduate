package com.corner.dao.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corner.dao.servlet.IModel;
import com.corner.dap.impl.HousesDao;
import com.corner.dap.impl.LocatesDao;
import com.corner.entity.Houses;
import com.corner.entity.Locates;

public class initSearch implements IModel
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		HousesDao houseDao=new HousesDao();
		ArrayList<Houses> houses=houseDao.findAllHouse();
		request.setAttribute("houses", houses);
		
		/**
		 * 初始化所有的地点
		 */
		LocatesDao locatesDao=new LocatesDao();
		ArrayList<Locates> locates=locatesDao.findAllRegion();
		request.setAttribute("locates", locates);
		
		/**
		 * 设置页码
		 */
		request.setAttribute("pageNum", 12);
		
		// TODO Auto-generated method stub
		return "WEB-INF/pages/search.jsp";
	}

}
