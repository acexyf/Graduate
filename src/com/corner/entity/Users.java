package com.corner.entity;

public class Users
{
	/**
	 * 用户编号
	 */
	private int userid;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String pwd;
	/**
	 * 用户手机号
	 */
	private String phone;
	/**
	 * 用户邮箱地址
	 */
	private String mail;
	/**
	 * 用户是否被冻结1：被冻结；0：未被冻结
	 */
	private int isfreezed;
	/**
	 * 用户头像地址
	 */
	private String userhead;
	public int getUserid()
	{
		return userid;
	}
	public void setUserid(int userid)
	{
		this.userid = userid;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getMail()
	{
		return mail;
	}
	public void setMail(String mail)
	{
		this.mail = mail;
	}
	public int getIsfreezed()
	{
		return isfreezed;
	}
	public void setIsfreezed(int isfreezed)
	{
		this.isfreezed = isfreezed;
	}
	public String getUserhead()
	{
		return userhead;
	}
	public void setUserhead(String userhead)
	{
		this.userhead = userhead;
	}
	public Users(int userid, String username, String pwd, String phone,
			String mail, int isfreezed, String userhead)
	{
		super();
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.phone = phone;
		this.mail = mail;
		this.isfreezed = isfreezed;
		this.userhead = userhead;
	}
	public Users()
	{
		super();
	}
	
}
