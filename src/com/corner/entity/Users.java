package com.corner.entity;

public class Users
{
	/**
	 * �û����
	 */
	private int userid;
	/**
	 * �û���
	 */
	private String username;
	/**
	 * �û�����
	 */
	private String pwd;
	/**
	 * �û��ֻ���
	 */
	private String phone;
	/**
	 * �û������ַ
	 */
	private String mail;
	/**
	 * �û��Ƿ񱻶���1�������᣻0��δ������
	 */
	private int isfreezed;
	/**
	 * �û�ͷ���ַ
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
