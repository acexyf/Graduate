package com.corner.entity;

public class Locates
{
	private int locateid;
	private String locatename;
	public int getLocateid()
	{
		return locateid;
	}
	public void setLocateid(int locateid)
	{
		this.locateid = locateid;
	}
	public String getLocatename()
	{
		return locatename;
	}
	public void setLocatename(String locatename)
	{
		this.locatename = locatename;
	}
	public Locates(int locateid, String locatename)
	{
		super();
		this.locateid = locateid;
		this.locatename = locatename;
	}
	public Locates()
	{
		super();
	}
	
}
