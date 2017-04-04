package com.orm;

/**
 * <p>Description: 管理员</p>
 * <p>Company: NJUST</p>
 * @author 刘龙强
 * @date 2017-4-1
 */
public class TAdmin
{
	/**
	 * 管理员ID，主键，自动递增型
	 */
	private int userId;
	
	/**
	 * 管理员姓名，NULL允许，默认admin
	 */
	private String userName;

	/**
	 * 管理员密码，NULL允许，默认123
	 */
	private String userPw;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

}
