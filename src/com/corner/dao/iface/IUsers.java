package com.corner.dao.iface;

import com.corner.entity.Users;



public interface IUsers
{
	/**
	 * 根据用户名找到该用户
	 * @param name
	 * @return
	 */
	public abstract Users findUserByName(String name);
	
	/**
	 * 根据用户ID找到该用户
	 * @param id
	 * @return
	 */
	public abstract Users findUserByID(int id);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public abstract boolean addUser(Users user);
	
}
