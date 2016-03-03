package com.corner.ajax;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.corner.dao.servlet.IModel;
import com.corner.util.tools.VerifyCodeUtils;

/**
 * ������֤�벢��ŵ�session����
 * @author CORNER
 *
 */
public class GenerateCode implements IModel
{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response)
	{
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
          
        //��������ִ�  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //����Ựsession  
        HttpSession session = request.getSession(true);  

        session.setAttribute("verifyCode", verifyCode.toLowerCase());  
//        System.out.println(session.getAttribute("verifyCode"));

        //����ͼƬ  
        int w = 200, h = 80;  
        try
		{
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

}
