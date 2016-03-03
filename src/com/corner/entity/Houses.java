package com.corner.entity;

import java.sql.Timestamp;

public class Houses
{
	/**
	 * 房屋编号
	 */
	private int houseid;
	/**
	 * 房屋标题
	 */
	private String title;
	/**
	 * 房源类型：住宅，别墅，写字楼，商铺
	 */
	private String genre;
	/**
	 * 出租方式：整租、合租
	 */
	private String ways;
	/**
	 * 小区名称
	 */
	private String resident;
	/**
	 * 区域
	 */
	private Locates region;
	/**
	 * 详细地址
	 */
	private String locations;
	/**
	 * 户型
	 */
	private int layout;
	/**
	 * 建筑面积
	 */
	private int area;
	/**
	 * 装修程度：豪华装修、精装修、中等装修、简装修、毛坯
	 */
	private String decorate;
	/**
	 * 朝向
	 */
	private String orient;
	/**
	 * 楼层
	 */
	private int floor;
	/**
	 * 总的楼层
	 */
	private int floors;
	/**
	 * 描述
	 */
	private String depict;
	/**
	 * 发布时间
	 */
	private Timestamp release;
	/**
	 * 是否通过审核 1:通过审核 0:未通过审核 2:已删除
	 */
	private int ispassed;
	/**
	 * 价格 
	 */
	private int price;
	/**
	 * 图片地址
	 */
	private String image;
	/**
	 * 发布用户
	 */
	private Users userid;

	public int getHouseid()
	{
		return houseid;
	}
	public void setHouseid(int houseid)
	{
		this.houseid = houseid;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getGenre()
	{
		return genre;
	}
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	public String getWays()
	{
		return ways;
	}
	public void setWays(String ways)
	{
		this.ways = ways;
	}
	public String getResident()
	{
		return resident;
	}
	public void setResident(String resident)
	{
		this.resident = resident;
	}
	public Locates getRegion()
	{
		return region;
	}
	public void setRegion(Locates region)
	{
		this.region = region;
	}
	public String getLocations()
	{
		return locations;
	}
	public void setLocations(String locations)
	{
		this.locations = locations;
	}
	public int getLayout()
	{
		return layout;
	}
	public void setLayout(int layout)
	{
		this.layout = layout;
	}
	public int getArea()
	{
		return area;
	}
	public void setArea(int area)
	{
		this.area = area;
	}
	public String getDecorate()
	{
		return decorate;
	}
	public void setDecorate(String decorate)
	{
		this.decorate = decorate;
	}
	public String getOrient()
	{
		return orient;
	}
	public void setOrient(String orient)
	{
		this.orient = orient;
	}
	public int getFloor()
	{
		return floor;
	}
	public void setFloor(int floor)
	{
		this.floor = floor;
	}
	public String getDepict()
	{
		return depict;
	}
	public void setDepict(String depict)
	{
		this.depict = depict;
	}
	public Timestamp getRelease()
	{
		return release;
	}
	public void setRelease(Timestamp release)
	{
		this.release = release;
	}
	public Users getUserid()
	{
		return userid;
	}
	public void setUserid(Users userid)
	{
		this.userid = userid;
	}
	public int getIspassed()
	{
		return ispassed;
	}
	public void setIspassed(int ispassed)
	{
		this.ispassed = ispassed;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	public Houses()
	{
		super();
	}
	public int getFloors()
	{
		return floors;
	}
	public void setFloors(int floors)
	{
		this.floors = floors;
	}
	public Houses(int houseid, String title, String genre, String ways,
			String resident, Locates region, String locations, int layout,
			int area, String decorate, String orient, int floor, int floors,
			String depict, Timestamp release, int ispassed, int price,
			String image, Users userid)
	{
		super();
		this.houseid = houseid;
		this.title = title;
		this.genre = genre;
		this.ways = ways;
		this.resident = resident;
		this.region = region;
		this.locations = locations;
		this.layout = layout;
		this.area = area;
		this.decorate = decorate;
		this.orient = orient;
		this.floor = floor;
		this.floors = floors;
		this.depict = depict;
		this.release = release;
		this.ispassed = ispassed;
		this.price = price;
		this.image = image;
		this.userid = userid;
	}
	
}
