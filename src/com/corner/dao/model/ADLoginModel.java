package com.corner.dao.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corner.dao.servlet.IModel;
import com.corner.dap.impl.AdminsDao;
import com.corner.entity.Admins;
import com.corner.util.tools.MD5;

public class ADLoginModel implements IModel
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "text/plain");
		String back="";
		String name=request.getParameter("name");
		if(name==null)
		{
			back="{\"status\":\"error\",\"type\":0}";
		}
		else
		{
			AdminsDao adminsDao=new AdminsDao();
			Admins admin=adminsDao.findAdminByName(name);
			if(admin==null)
			{
				back="{\"status\":\"error\",\"type\":1}";
			}
			else
			{
				String pwd=request.getParameter("pwd");
				pwd=MD5.GetMD5Code(pwd);
				if(!pwd.equals(admin.getAdminpwd()))
				{
					back="{\"status\":\"error\",\"type\":2}";
				}
				else
				{
					back="{\"status\":\"ok\"}";
				}
			}
		}
		
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(back);
		out.flush();
		out.close();
		
		return "";
	}

}
