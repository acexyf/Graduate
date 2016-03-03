package com.corner.dao.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corner.dao.servlet.IModel;

public class initLogin implements IModel
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		return "WEB-INF/pages/login.jsp";
	}

}
