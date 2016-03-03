package com.corner.dao.iface;

import java.util.ArrayList;

import com.corner.entity.Locates;

public interface ILocates
{
	/**
	 * 找到所有的区域（非重复）
	 */
	public abstract ArrayList<Locates> findAllRegion();
}
