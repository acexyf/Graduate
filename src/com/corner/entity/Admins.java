package com.corner.entity;

public class Admins
{
	/**
	 * ����Ա���
	 */
	private int adminid;
	/**
	 * ����Ա��¼��
	 */
	private String adminname;
	/**
	 * ����Ա����
	 */
	private String adminpwd;
	/**
	 * ����Ա�ȼ�
	 */
	private int adminlevel;
	/**
	 * ����Ա�˺��Ƿ񱻶��� 0��δ������ 1���ѱ�����
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
