package com.corner.dao.iface;

import java.util.ArrayList;

import com.corner.entity.Houses;

public interface IHouses
{
	/**
	 * ���ݷ��ݱ���ҵ��÷���
	 */
	public abstract Houses findHouseById(int houseid);
	
	/**
	 * �ҵ����еķ���
	 */
	public abstract ArrayList<Houses> findAllHouse();
	
	/**
	 * �����������ҷ���
	 */
	public abstract ArrayList<Houses> findHouseFollow(String condition);
	
	/**
	 * �����������ҷ��ݵ�����
	 * @return
	 */
	public abstract int findNumberFollow(String condition);
	/**
	 * ��������
	 */
	public abstract boolean addHouses(Houses houses);
}
