package com.corner.util.tools;

import java.util.ArrayList;

import com.corner.entity.Houses;

public class ToJson
{
	/**
	 * 将Houses列表转成json数据格式
	 * @param list
	 * @return
	 */
	public static String GetJson(ArrayList<Houses> list,int currentPage, int sumPage)
	{
		String json="{\"status\":\"ok\",\"number\":"+list.size()+",\"data\":[";
		String temp="";
		for(Houses house:list)
		{
//			String temp="{\"houseid\":\""+house.getHouseid()+"\",\"title\":\""+house.getTitle()+"\",\"genre\":\""+house.getGenre()+"\",\"ways\":\""+house.getWays()+"\",\"resident\":\""+house.getResident()+"\",\"region\":\""+house.getRegion()+"\",\"locations\":\""+house.getLocations()+"\",\"layout\":\""+house.getLayout()+"\",\"area\":\""+house.getArea()+"\",\"decorate\":\""+house.getDecorate()+"\",\"orient\":\""+house.getOrient()+"";
			temp+="{\"houseid\":\""+house.getHouseid()+"\",\"image\":"+house.getImage()+"\",\"title\":\""+house.getTitle()+"\",\"region\":\""+house.getRegion().getLocatename()+"\",\"resident\":\""+house.getResident()+"\",\"locations\":\""+house.getLocations()+"\",\"ways\":\""+house.getWays()+"\",\"area\":\""+house.getArea()+"平方米\",\"decorate\":\""+house.getDecorate()+"\",\"floor\":\""+house.getFloor()+"层\",\"floors\":\""+house.getFloors()+"层\",\"orient\":\""+house.getOrient()+"\",\"price\":\""+house.getPrice()+"\",\"layout\":"+house.getLayout()+"},";
		}
		//去掉,
		int l=temp.length();
		if(l!=0)
		{
			temp=temp.substring(0, l-1);
		}
		else
		{
			temp="";
		}
		json=json+temp;
		json+="],\"currentPage\":"+currentPage+",\"sumPage\":"+sumPage+"}";
		
		return json;
	}
}
