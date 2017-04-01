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
import com.orm.User;

public class user_servlet extends HttpServlet
{ 
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		String type=req.getParameter("type");
		
		if(type.endsWith("userReg"))
		{
			userReg(req, res);
		}
		if(type.endsWith("userMana"))
		{
			userMana(req, res);
		}
		if(type.endsWith("userDel"))
		{
			userDel(req, res);
		}
	}
	
	
	
	
	public void userReg(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String age=req.getParameter("age");
		String tel=req.getParameter("tel");
		String address=req.getParameter("address");
		String loginName=req.getParameter("loginName");
		String loginPw=req.getParameter("loginPw");
		
		String sql="insert into t_user(name,sex,age,tel,address,loginName,loginPw,del) values(?,?,?,?,?,?,?,?)";
		Object[] params={name,sex,age,tel,address,loginName,loginPw,"no"};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
        String targetURL = "/userReg_re.jsp";
		dispatch(targetURL, req, res);
	}
	public void userDel(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		String sql="update t_user set del=? where id=?";
		Object[] params={"yes",id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user?type=userMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void userMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List userList=new ArrayList();
		String sql="select * from t_user where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getString("age"));
				user.setTel(rs.getString("tel"));
				user.setAddress(rs.getString("address"));
				user.setLoginName(rs.getString("loginName"));
				user.setLoginPw(rs.getString("loginPw"));
				userList.add(user);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("admin/user/userMana.jsp").forward(req, res);
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
