package com.corner.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.corner.dao.servlet.IModel;

/**
 * 从session中取出验证码并返回
 * @author CORNER
 *
 */
public class VerifyCode implements IModel
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		HttpSession session = request.getSession(false);  
		
		String verifyCode=(String) session.getAttribute("verifyCode");
		
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(verifyCode);
		out.flush();
		out.close();
		
		return "";
	}

}
