package com.corner.dao.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter
{

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8"); 
		HttpServletRequest req=(HttpServletRequest)request;
		String method=req.getMethod();
		if(method.equals("POST"))
		{
			req.setCharacterEncoding("utf-8");
		}
		else
		{ 
			Enumeration<String> names=req.getParameterNames();
			while(names.hasMoreElements())
			{
				String key=names.nextElement();
				String[] values=req.getParameterValues(key);
				
				for(int i=0;i<values.length;i++)
				{
					values[i]=new String(values[i].getBytes("iso-8859-1"), "utf-8");
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub

	}

}
