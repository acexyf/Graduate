package com.corner.entity;

public class Admins
{
	/**
	 * 管理员编号
	 */
	private int adminid;
	/**
	 * 管理员登录名
	 */
	private String adminname;
	/**
	 * 管理员密码
	 */
	private String adminpwd;
	/**
	 * 管理员等级
	 */
	private int adminlevel;
	/**
	 * 管理员账号是否被冻结 0：未被冻结 1：已被冻结
	 */
	private int isfreezed;
	public int getAdminid()
	{
		return adminid;
	}
	public void setAdminid(int adminid)
	{
		this.adminid = adminid;
	}
	public String getAdminname()
	{
		return adminname;
	}
	public void setAdminname(String adminname)
	{
		this.adminname = adminname;
	}
	public String getAdminpwd()
	{
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd)
	{
		this.adminpwd = adminpwd;
	}
	public int getAdminlevel()
	{
		return adminlevel;
	}
	public void setAdminlevel(int adminlevel)
	{
		this.adminlevel = adminlevel;
	}
	public int getIsfreezed()
	{
		return isfreezed;
	}
	public void setIsfreezed(int isfreezed)
	{
		this.isfreezed = isfreezed;
	}
	public Admins(int adminid, String adminname, String adminpwd,
			int adminlevel, int isfreezed)
	{
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminpwd = adminpwd;
		this.adminlevel = adminlevel;
		this.isfreezed = isfreezed;
	}
	public Admins()
	{
		super();
	}
	
}
