package com.corner.dao.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.UserDataHandler;

import com.corner.dao.servlet.IModel;
import com.corner.dap.impl.UsersDao;
import com.corner.entity.Users;
import com.corner.util.tools.MD5;

public class RegisterModel implements IModel
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		String back="";
		String username=request.getParameter("username");
		System.out.println(username);
		UsersDao usersDao=new UsersDao();
		Users users=usersDao.findUserByName(username);
		if(users==null)
		{
			users=new Users();
			String pwd=request.getParameter("pwd");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			users.setUserid(0);
			users.setUsername(username);
			pwd=MD5.GetMD5Code(pwd);
			users.setPwd(pwd);
			users.setPhone(phone);
			users.setMail(email);
			users.setIsfreezed(0);
			users.setUserhead("images/userheader.jpg");
			back="ok";
			usersDao.addUser(users);
		}
		else
		{
			back="repeat";
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
		return "";
	}
}
