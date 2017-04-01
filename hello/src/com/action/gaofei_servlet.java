package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tgaofei;
import com.orm.Tzhuanjia;
import com.orm.User;
import com.service.liuService;

public class gaofei_servlet extends HttpServlet
{ 
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("gaofeiAdd"))
		{
			gaofeiAdd(req, res);
		}
		if(type.endsWith("gaofeiMana"))
		{
			gaofeiMana(req, res);
		}
		if(type.endsWith("gaofeiDel"))
		{
			gaofeiDel(req, res);
		}
	}
	
	
	
	
	public void gaofeiAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String shijian=req.getParameter("shijian");
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		int jine=Integer.parseInt(req.getParameter("jine"));
		String del="no";
		
		String sql="insert into t_gaofei(jine,shijian,user_id,del) values(?,?,?,?)";
		Object[] params={jine,shijian,user_id,"no"};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "gaofei?type=gaofeiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void gaofeiDel(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		String sql="update t_gaofei set del=? where id=?";
		Object[] params={"yes",id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "gaofei?type=gaofeiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void gaofeiMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List gaofeiList=new ArrayList();
		String sql="select * from t_gaofei where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgaofei gaofei=new Tgaofei();
				gaofei.setId(rs.getInt("id"));
				gaofei.setShijian(rs.getString("shijian"));
				gaofei.setJine(rs.getInt("jine"));
				gaofei.setUser_id(rs.getInt("user_id"));
				gaofei.setUser_name(liuService.getUserName(rs.getInt("user_id")));
				
				gaofeiList.add(gaofei);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gaofeiList", gaofeiList);
		req.getRequestDispatcher("admin/gaofei/gaofeiMana.jsp").forward(req, res);
	}
	
	
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
