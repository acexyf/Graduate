package com.corner.dao.iface;

import com.corner.entity.Admins;

public interface IAdmins
{
	/**
	 * ���ݹ���Ա�����ҵ�����Ա
	 * @return
	 */
	public abstract Admins findAdminByName(String name);
}
