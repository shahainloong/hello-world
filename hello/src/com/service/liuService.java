package com.service;

import java.sql.ResultSet;

import com.dao.DB;

public class liuService
{
	
	public static String getUserName(int id)
	{
		String name="";
		
		String sql="select * from t_user where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			name=rs.getString("name");
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return name;
	}
}
