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
import com.orm.Tzhuanjia;
import com.orm.User;


/**
 * <p>Description: 专家servlet</p>
 * <p>Company: NJUST</p>
 * @author 刘龙强
 * @date 2017-4-9
 */
public class zhuanjia_servlet extends HttpServlet
{ 
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		/*获取type类型*/
		String type=req.getParameter("type");
		
		if(type.endsWith("zhuanjiaAdd"))
		{
			zhuanjiaAdd(req, res);
		}
		if(type.endsWith("zhuanjiaMana"))
		{
			zhuanjiaMana(req, res);
		}
		if(type.endsWith("zhuanjiaDel"))
		{
			zhuanjiaDel(req, res);
		}
	}
	
	/**
	 * 添加专家
	 * @param req
	 * @param res
	 */
	public void zhuanjiaAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String age=req.getParameter("age");
		String tel=req.getParameter("tel");
		String address=req.getParameter("address");
		String loginName=req.getParameter("loginName");
		String loginPw=req.getParameter("loginPw");
		
		String sql="insert into t_zhuanjia(name,sex,age,tel,address,loginName,loginPw,del) values(?,?,?,?,?,?,?,?)";
		Object[] params={name,sex,age,tel,address,loginName,loginPw,"no"};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhuanjia?type=zhuanjiaMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	/**
	 * 删除专家
	 * @param req
	 * @param res
	 */
	public void zhuanjiaDel(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		String sql="update t_zhuanjia set del=? where id=?";
		Object[] params={"yes",id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "zhuanjia?type=zhuanjiaMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	/**
	 * 专家管理
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	public void zhuanjiaMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List zhuanjiaList=new ArrayList();
		String sql="select * from t_zhuanjia where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tzhuanjia zhuanjia=new Tzhuanjia();
				zhuanjia.setId(rs.getInt("id"));
				zhuanjia.setName(rs.getString("name"));
				zhuanjia.setSex(rs.getString("sex"));
				zhuanjia.setAge(rs.getString("age"));
				zhuanjia.setTel(rs.getString("tel"));
				zhuanjia.setAddress(rs.getString("address"));
				zhuanjia.setLoginName(rs.getString("loginName"));
				zhuanjia.setLoginPw(rs.getString("loginPw"));
				zhuanjiaList.add(zhuanjia);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("zhuanjiaList", zhuanjiaList);
		req.getRequestDispatcher("admin/zhuanjia/zhuanjiaMana.jsp").forward(req, res);
	}

	/**
	 * V-C映射
	 * @param targetURI
	 * @param request
	 * @param response
	 */
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
