package com.corner.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.corner.dao.servlet.IModel;
import com.corner.dap.impl.HousesDao;
import com.corner.entity.Houses;
import com.corner.util.tools.ToJson;
import com.sun.media.sound.JavaSoundAudioClip;

/**
 * ����post������������ҷ�����Ϣ��������json
 * @author CORNER
 *
 */
public class SearchAjax implements IModel
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		response.setHeader("Access-Control-Allow-Origin", "*");
		ResourceBundle bundle=ResourceBundle.getBundle("ConDB");
		int pageCount=Integer.parseInt(bundle.getString("pageCount"));
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String back="";
		// TODO Auto-generated method stub
		//���ҷ�����Ϣ
		StringBuffer condition=new StringBuffer("select houseid,title,genre,ways,resident,locateid,locatename,locations,layout,area,decorate,orient,floor,floors,depict,release,ispassed,price,image,u.userid,u.username,u.pwd,u.phone,u.mail,u.isfreezed,u.userhead from houses h,users u,locates l where h.userid=u.userid and l.locateid=h.region and ispassed=1 ");
		//�����ܵ�����
		StringBuffer condition1=new StringBuffer("select max(rownum) from houses h,users u,locates l where h.userid=u.userid and l.locateid=h.region and ispassed=1 ");
		StringBuffer temp=new StringBuffer();
		
		String locateid=request.getParameter("locateid");
		if(locateid==null)
		{
			back="{'status':'error','number':0}";
		}
		else
		{
			int currentPage=Integer.parseInt(request.getParameter("currentPage"));
			int price=Integer.parseInt(request.getParameter("price"));
			int layout=Integer.parseInt(request.getParameter("layout"));
			String ways=request.getParameter("ways");
			String decorate=request.getParameter("decorate");
			String orient=request.getParameter("orient");
			int floor=Integer.parseInt(request.getParameter("floor"));
			
			//�ж�����
			if(!("0".equals(locateid)))
			{
				temp.append(" locateid = '"+locateid+"' and");
			}
			//�ж����
			switch (price)
			{
			case 1:
				temp.append(" price between 0 and 500 and");
				break;
			case 2:
				temp.append(" price between 500 and 1000 and");	
				break;
			case 3:
				temp.append(" price between 1000 and 1500 and");
				break;
			case 4:
				temp.append(" price between 1500 and 3000 and");
				break;
			case 5:
				temp.append(" price >3000 and");
				break;
			default:
				
				break;
			}
			//�жϻ���
			switch (layout)
			{
			case 0:
				
				break;
			case 1:
				temp.append(" layout between 100 and 199 and");		
				break;
			case 2:
				temp.append(" layout between 200 and 299 and");
				break;
			case 3:
				temp.append(" layout between 300 and 399 and");
				break;
			case 4:
				temp.append(" layout between 400 and 499 and");
				break;
			case 5:
				temp.append(" layout > 500 and");
				break;
			default:
				
				break;
			}
			
			//�ж���ס��ʽ
			if(!("0".equals(ways)))
			{
				temp.append(" ways = '"+ways+"' and");
			}
			
			//�ж�װ�޷�ʽ
			if(!("0".equals(decorate)))
			{
				temp.append(" decorate = '"+decorate+"' and");
			}
			
			//�жϳ���
			if(!("0".equals(orient)))
			{
				//����ֻ��һ���֣������ϣ�������
				if(orient.length()==1)
				{
					temp.append(" orient like '%"+orient+"%' and");
				}
				else//����Ϊ�������ϱ�
				{
					if("����".equals(orient))
					{
						temp.append(" orient like '%��%' or orient like '%��%' and");
					}
					else
					{
						temp.append(" orient like '%��%' or orient like '%��%' and");
					}
				}
			}
			
			//�ж�¥��
			
			switch (floor)
			{
			case 0:
				
				break;
			case 1:
				temp.append(" floor<6 and");		
				break;
			case 2:
				temp.append(" floor between 6 and 12 and");
				break;
			case 3:
				temp.append(" floor > 12 and");
				break;
			default:
				break;
			}
			
			HousesDao housesDao=new HousesDao();
			
			int length=temp.length();
			if(length!=0)
			{
				condition=condition.append(" and");
				condition1=condition1.append(" and");
				temp=temp.delete(length-3, length);
			}
			
			//ƴ�����1
			condition=condition.append(temp);
			
			int begin=(currentPage-1)*pageCount+1;
			int end=currentPage*pageCount;
			
			condition=condition.append("and rownum between "+begin+" and "+end+" order by houseid");
			System.out.println(condition);
			ArrayList<Houses> list=housesDao.findHouseFollow(condition.toString());
			
			//ƴ�����2
			condition1=condition1.append(temp);
			condition1=condition1.append("order by h.houseid");
			int totalCount=housesDao.findNumberFollow(condition1.toString());
			
			
			back=ToJson.GetJson(list, currentPage, (totalCount-1)/pageCount+1);
			
		}
		System.out.println(back);
		out.print(back);
		out.flush();

		return "";
	}

}
