package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;


import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tzhuanjia;
import com.orm.User;

public class loginService
{
	
	
	
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//ÏµÍ³¹ÜÀíÔ±µÇÂ½
		{
			String sql="select * from t_admin where userName=? and userPw=?";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					 TAdmin admin=new TAdmin();
					 admin.setUserId(rs.getInt("userId"));
					 admin.setUserName(rs.getString("userName"));
					 admin.setUserPw(rs.getString("userPw"));
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 session.setAttribute("userType", 0);
		             session.setAttribute("admin", admin);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("µÇÂ¼Ê§°Ü£¡");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
			
		}
		
		
		if(userType==1)
		{
			String sql="select * from t_zhuanjia where loginName=? and loginPw=?";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					 Tzhuanjia zhuanjia=new Tzhuanjia();
					 zhuanjia.setId(rs.getInt("id"));
					 zhuanjia.setName(rs.getString("name"));
					 zhuanjia.setSex(rs.getString("sex"));
					 zhuanjia.setAge(rs.getString("age"));
					 zhuanjia.setTel(rs.getString("tel"));
					 zhuanjia.setAddress(rs.getString("address"));
					 zhuanjia.setLoginName(rs.getString("loginName"));
					 zhuanjia.setLoginPw(rs.getString("loginPw"));
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 session.setAttribute("userType", 1);
		             session.setAttribute("zhuanjia", zhuanjia);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("µÇÂ¼Ê§°Ü£¡");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
		}
		if(userType==2)
		{
			String sql="select * from t_user where loginName=? and loginPw=?";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					 User user=new User();
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setSex(rs.getString("sex"));
						user.setAge(rs.getString("age"));
						user.setTel(rs.getString("tel"));
						user.setAddress(rs.getString("address"));
						user.setLoginName(rs.getString("loginName"));
						user.setLoginPw(rs.getString("loginPw"));
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 session.setAttribute("userType", 2);
		             session.setAttribute("user", user);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("µÇÂ¼Ê§°Ü£¡");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		
		String sql="update t_admin set userPw=? where userId=?";
		Object[] params={userPwNew,admin.getUserId()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		
		return "yes";
    }
    
    
    public String userPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		User user=(User)session.getAttribute("user");
		
		String sql="update t_user set loginPw=? where id=?";
		Object[] params={userPwNew,user.getId()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		
		return "yes";
    }
    
    
    public List userSelect()
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
				userList.add(user);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return userList;
    }
    
    

}
