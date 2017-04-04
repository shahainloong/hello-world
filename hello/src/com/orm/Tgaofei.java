package com.orm;

/**
 * <p>Description: 稿费</p>
 * <p>Company: NJUST</p>
 * @author 刘龙强
 * @date 2017-4-1
 */
public class Tgaofei
{
	/**
	 * 稿费ID，主键，自动递增型
	 */
	private int id;
	
	/**
	 * 金额
	 */
	private int jine;
	
	/**
	 * 提交时间
	 */
	private String shijian;
	
	/**
	 * 关联用户ID
	 */
	private int user_id;
	
	/**
	 * 删除标识符
	 */
	private String del;
	
	/**
	 * 关联用户姓名
	 */
	private String user_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJine() {
		return jine;
	}

	public void setJine(int jine) {
		this.jine = jine;
	}

	public String getShijian() {
		return shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
