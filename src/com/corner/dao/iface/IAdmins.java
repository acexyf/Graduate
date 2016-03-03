package com.corner.dao.iface;

import com.corner.entity.Admins;

public interface IAdmins
{
	/**
	 * 根据管理员名字找到管理员
	 * @return
	 */
	public abstract Admins findAdminByName(String name);
}
