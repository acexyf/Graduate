package com.corner.dao.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.corner.ajax.GenerateCode;
import com.corner.ajax.SearchAjax;
import com.corner.ajax.VerifyCode;
import com.corner.dao.model.RegisterModel;

import com.corner.dao.model.ADLoginModel;
import com.corner.dao.model.initAdminLogin;
import com.corner.dao.model.initHome;
import com.corner.dao.model.initHouse;
import com.corner.dao.model.initRegister;
import com.corner.dao.model.initSearch;
import com.corner.dao.model.LoginModel;
import com.corner.dao.model.initLogin;


public class Action extends HttpServlet
{
	//在serlvet中获取application
	ServletContext application;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		String key=req.getParameter("key");
		if(key==null)
		{
			req.getRequestDispatcher("WEB-INF/pages/error.jsp").forward(req, resp);
		}
		else
		{
			System.out.println("key:"+key);
			IModel model=(IModel)application.getAttribute(key);
			String path="";
			if(model==null)
			{
				path="WEB-INF/pages/error.jsp";
			}
			else
			{
				path=model.execute(req, resp);
			}
			System.out.println("path:"+path);
			if(!path.equals(""))
				req.getRequestDispatcher(path).forward(req, resp);
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		// TODO Auto-generated method stub
		application=config.getServletContext();
		application.setAttribute("initHome", new initHome());
		application.setAttribute("initLogin", new initLogin());
		application.setAttribute("initRegister", new initRegister());
		application.setAttribute("initSearch", new initSearch());
		application.setAttribute("initAdminLogin", new initAdminLogin());
		application.setAttribute("initHouse", new initHouse());
		application.setAttribute("LoginModel", new LoginModel());
		application.setAttribute("SearchAjax", new SearchAjax());
		application.setAttribute("GenerateCode", new GenerateCode());
		application.setAttribute("VerifyCode", new VerifyCode());
		application.setAttribute("RegisterModel", new RegisterModel());
		application.setAttribute("ADLoginModel", new ADLoginModel());
		super.init(config);
	}
	
}
