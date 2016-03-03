package com.corner.dao.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IModel
{
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String execute(HttpServletRequest request,HttpServletResponse response);
}
