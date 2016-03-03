package com.corner.dao.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corner.dao.servlet.IModel;
import com.corner.dap.impl.UsersDao;
import com.corner.entity.Users;
import com.corner.util.tools.MD5;

public class LoginModel implements IModel
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		UsersDao usersDao=new UsersDao();
		Users user=usersDao.findUserByName(username);
		if(user!=null)
		{
			String pwd=request.getParameter("pwd");
			pwd=MD5.GetMD5Code(pwd);
			if(pwd.equals(user.getPwd()))
			{
				String ck=request.getParameter("checkbox");
				//记住用户名和密码
				if("on".equals(ck))
				{
					Cookie nameCookie =new Cookie("username", username);
					Cookie pwdCookie =new Cookie("password", pwd);
					nameCookie.setMaxAge(7*24*60*60);
					pwdCookie.setMaxAge(7*24*60*60);
					response.addCookie(nameCookie);
					response.addCookie(pwdCookie);
				}
				else
				{
					Cookie[] cookies=request.getCookies();
					if(cookies!=null)
					{
						for(int i=0;i<cookies.length;i++)
						{
							cookies[i].setMaxAge(0);
							response.addCookie(cookies[i]);
						}
					}
				}
				//登录成功
				request.getSession().setAttribute("user", user);
				return "";
			}
			else 
			{
				request.setAttribute("error", "密码错误");
				return "WEB-INF/pages/login.jsp";
			}
		}
		else {
			request.setAttribute("error", "用户名不存在");
			return "WEB-INF/pages/login.jsp";
		}
	}

}
