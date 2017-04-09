package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tgaojian;
import com.orm.User;

/**
 * <p>Description: 稿件servlet</p>
 * <p>Company: NJUST</p>
 * @author 刘龙强
 * @date 2017-4-9
 */
public class gaojian_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
        
        if(type.endsWith("gaojianAdd"))
		{
			gaojianAdd(req, res);
		}
		if(type.endsWith("gaojianMy"))
		{
			gaojianMy(req, res);
		}
		if(type.endsWith("gaojianDel"))
		{
			gaojianDel(req, res);
		}
		
		if(type.endsWith("gaojianDaishen_zhuanjia"))
		{
			gaojianDaishen_zhuanjia(req, res);
		}
		if(type.endsWith("gaojianShe_zhuanjia"))
		{
			gaojianShe_zhuanjia(req, res);
		}
		if(type.endsWith("gaojianYishen_zhuanjia"))
		{
			gaojianYishen_zhuanjia(req, res);
		}
		
        
		if(type.endsWith("gaojianDaishen_admin"))
		{
			gaojianDaishen_admin(req, res);
		}
		if(type.endsWith("gaojianShe_admin"))
		{
			gaojianShe_admin(req, res);
		}
		if(type.endsWith("gaojianYishen_admin"))
		{
			gaojianYishen_admin(req, res);
		}
       
	}
	
	/*添加稿件*/
	public void gaojianAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String fujian=req.getParameter("fujian");
		String fujianYuanshiming=req.getParameter("fujianYuanshiming");
		
		String shijian=new Date().toLocaleString();
		int user_id=((User)req.getSession().getAttribute("user")).getId();
		String zhuanjiashenhebiaozhi="shenhezhong";
		String zhuanjiashenheyijian="";
		
		String zhubianshenhebiaozhi="shenhezhong";
		String zhubianshenheyijian="";
		String shifoufabiao="fou";
		String del="no";
		
		String sql="insert into t_gaojian(title,content,fujian,fujianYuanshiming," +
				"shijian,user_id,zhuanjiashenhebiaozhi,zhuanjiashenheyijian," +
				"zhubianshenhebiaozhi,zhubianshenheyijian,shifoufabiao,del) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={title,content,fujian,fujianYuanshiming,
				         shijian,user_id,zhuanjiashenhebiaozhi,zhuanjiashenheyijian,
				         zhubianshenhebiaozhi,zhubianshenheyijian,shifoufabiao,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "gaojian?type=gaojianMy");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	/*我的稿件*/
	public void gaojianMy(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		int user_id=((User)req.getSession().getAttribute("user")).getId();
		
		List gaojianList=new ArrayList();
		String sql="select * from t_gaojian where del='no' and user_id="+user_id;
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgaojian gaojian=new Tgaojian();
				
				gaojian.setId(rs.getInt("id"));
				gaojian.setTitle(rs.getString("title"));
				gaojian.setContent(rs.getString("content"));
				gaojian.setFujian(rs.getString("fujian"));
				
				gaojian.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				gaojian.setShijian(rs.getString("shijian"));
				gaojian.setUser_id(rs.getInt("user_id"));
				gaojian.setZhuanjiashenhebiaozhi(rs.getString("zhuanjiashenhebiaozhi"));
				
				gaojian.setZhuanjiashenheyijian(rs.getString("zhuanjiashenheyijian"));
				gaojian.setZhubianshenhebiaozhi(rs.getString("zhubianshenhebiaozhi"));
				gaojian.setZhubianshenheyijian(rs.getString("zhubianshenheyijian"));
				gaojian.setShifoufabiao(rs.getString("shifoufabiao"));
				gaojian.setDel(rs.getString("del"));
				
				gaojianList.add(gaojian);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gaojianList", gaojianList);
		req.getRequestDispatcher("auser/gaojian/gaojianMy.jsp").forward(req, res);
	}
	

	
	
	
	public void gaojianDaishen_zhuanjia(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List gaojianList=new ArrayList();
		String sql="select * from t_gaojian where del='no' and zhuanjiashenhebiaozhi='shenhezhong'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgaojian gaojian=new Tgaojian();
				
				gaojian.setId(rs.getInt("id"));
				gaojian.setTitle(rs.getString("title"));
				gaojian.setContent(rs.getString("content"));
				gaojian.setFujian(rs.getString("fujian"));
				
				gaojian.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				gaojian.setShijian(rs.getString("shijian"));
				gaojian.setUser_id(rs.getInt("user_id"));
				gaojian.setZhuanjiashenhebiaozhi(rs.getString("zhuanjiashenhebiaozhi"));
				
				gaojian.setZhuanjiashenheyijian(rs.getString("zhuanjiashenheyijian"));
				gaojian.setZhubianshenhebiaozhi(rs.getString("zhubianshenhebiaozhi"));
				gaojian.setZhubianshenheyijian(rs.getString("zhubianshenheyijian"));
				gaojian.setShifoufabiao(rs.getString("shifoufabiao"));
				gaojian.setDel(rs.getString("del"));
				
				gaojianList.add(gaojian);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gaojianList", gaojianList);
		req.getRequestDispatcher("azhuanjia/gaojian/gaojianDaishen_zhuanjia.jsp").forward(req, res);
	}
	
	
	public void gaojianShe_zhuanjia(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String zhuanjiashenhebiaozhi=req.getParameter("zhuanjiashenhebiaozhi");
		String zhuanjiashenheyijian=req.getParameter("zhuanjiashenheyijian");
		
		String sql="update t_gaojian set zhuanjiashenhebiaozhi=?,zhuanjiashenheyijian=? where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={zhuanjiashenhebiaozhi,zhuanjiashenheyijian};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "操作成功");
		req.getRequestDispatcher("common/msg.jsp").forward(req, res);
	}
	
	public void gaojianYishen_zhuanjia(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List gaojianList=new ArrayList();
		String sql="select * from t_gaojian where del='no' and zhuanjiashenhebiaozhi !='shenhezhong'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgaojian gaojian=new Tgaojian();
				
				gaojian.setId(rs.getInt("id"));
				gaojian.setTitle(rs.getString("title"));
				gaojian.setContent(rs.getString("content"));
				gaojian.setFujian(rs.getString("fujian"));
				
				gaojian.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				gaojian.setShijian(rs.getString("shijian"));
				gaojian.setUser_id(rs.getInt("user_id"));
				gaojian.setZhuanjiashenhebiaozhi(rs.getString("zhuanjiashenhebiaozhi"));
				
				gaojian.setZhuanjiashenheyijian(rs.getString("zhuanjiashenheyijian"));
				gaojian.setZhubianshenhebiaozhi(rs.getString("zhubianshenhebiaozhi"));
				gaojian.setZhubianshenheyijian(rs.getString("zhubianshenheyijian"));
				gaojian.setShifoufabiao(rs.getString("shifoufabiao"));
				gaojian.setDel(rs.getString("del"));
				
				gaojianList.add(gaojian);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gaojianList", gaojianList);
		req.getRequestDispatcher("azhuanjia/gaojian/gaojianYishen_zhuanjia.jsp").forward(req, res);
	}
	
	
	
	public void gaojianDaishen_admin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List gaojianList=new ArrayList();
		String sql="select * from t_gaojian where del='no' and zhuanjiashenhebiaozhi='shenhetongguo' and zhubianshenhebiaozhi='shenhezhong'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgaojian gaojian=new Tgaojian();
				
				gaojian.setId(rs.getInt("id"));
				gaojian.setTitle(rs.getString("title"));
				gaojian.setContent(rs.getString("content"));
				gaojian.setFujian(rs.getString("fujian"));
				
				gaojian.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				gaojian.setShijian(rs.getString("shijian"));
				gaojian.setUser_id(rs.getInt("user_id"));
				gaojian.setZhuanjiashenhebiaozhi(rs.getString("zhuanjiashenhebiaozhi"));
				
				gaojian.setZhuanjiashenheyijian(rs.getString("zhuanjiashenheyijian"));
				gaojian.setZhubianshenhebiaozhi(rs.getString("zhubianshenhebiaozhi"));
				gaojian.setZhubianshenheyijian(rs.getString("zhubianshenheyijian"));
				gaojian.setShifoufabiao(rs.getString("shifoufabiao"));
				gaojian.setDel(rs.getString("del"));
				
				gaojianList.add(gaojian);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gaojianList", gaojianList);
		req.getRequestDispatcher("admin/gaojian/gaojianDaishen_admin.jsp").forward(req, res);
	}
	
	
	public void gaojianShe_admin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String zhubianshenhebiaozhi=req.getParameter("zhubianshenhebiaozhi");
		String zhubianshenheyijian=req.getParameter("zhubianshenheyijian");
		
		String sql="update t_gaojian set zhubianshenhebiaozhi=?,zhubianshenheyijian=? where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={zhubianshenhebiaozhi,zhubianshenheyijian};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "操作成功");
		req.getRequestDispatcher("common/msg.jsp").forward(req, res);
	}
	
	public void gaojianYishen_admin(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List gaojianList=new ArrayList();
		String sql="select * from t_gaojian where del='no' and zhuanjiashenhebiaozhi='shenhetongguo' and zhubianshenhebiaozhi !='shenhezhong'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tgaojian gaojian=new Tgaojian();
				
				gaojian.setId(rs.getInt("id"));
				gaojian.setTitle(rs.getString("title"));
				gaojian.setContent(rs.getString("content"));
				gaojian.setFujian(rs.getString("fujian"));
				
				gaojian.setFujianYuanshiming(rs.getString("fujianYuanshiming"));
				gaojian.setShijian(rs.getString("shijian"));
				gaojian.setUser_id(rs.getInt("user_id"));
				gaojian.setZhuanjiashenhebiaozhi(rs.getString("zhuanjiashenhebiaozhi"));
				
				gaojian.setZhuanjiashenheyijian(rs.getString("zhuanjiashenheyijian"));
				gaojian.setZhubianshenhebiaozhi(rs.getString("zhubianshenhebiaozhi"));
				gaojian.setZhubianshenheyijian(rs.getString("zhubianshenheyijian"));
				gaojian.setShifoufabiao(rs.getString("shifoufabiao"));
				gaojian.setDel(rs.getString("del"));
				
				gaojianList.add(gaojian);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("gaojianList", gaojianList);
		req.getRequestDispatcher("admin/gaojian/gaojianYishen_admin.jsp").forward(req, res);
	}
	

	public void gaojianDel(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println(req.getParameter("id")+"**");
		String sql="update t_gaojian set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "操作成功");
		req.getRequestDispatcher("common/msg.jsp").forward(req, res);
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
