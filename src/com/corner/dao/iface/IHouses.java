package com.corner.dao.iface;

import java.util.ArrayList;

import com.corner.entity.Houses;

public interface IHouses
{
	/**
	 * 根据房屋编号找到该房屋
	 */
	public abstract Houses findHouseById(int houseid);
	
	/**
	 * 找到所有的房屋
	 */
	public abstract ArrayList<Houses> findAllHouse();
	
	/**
	 * 根据条件查找房屋
	 */
	public abstract ArrayList<Houses> findHouseFollow(String condition);
	
	/**
	 * 根据条件查找房屋的总数
	 * @return
	 */
	public abstract int findNumberFollow(String condition);
	/**
	 * 新增房屋
	 */
	public abstract boolean addHouses(Houses houses);
}
