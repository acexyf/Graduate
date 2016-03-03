package com.corner.dao.iface;

import com.corner.entity.Users;



public interface IUsers
{
	/**
	 * �����û����ҵ����û�
	 * @param name
	 * @return
	 */
	public abstract Users findUserByName(String name);
	
	/**
	 * �����û�ID�ҵ����û�
	 * @param id
	 * @return
	 */
	public abstract Users findUserByID(int id);
	
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public abstract boolean addUser(Users user);
	
}
