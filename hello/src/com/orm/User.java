package com.orm;

/**
 * <p>Description: 一般用户</p>
 * <p>Company: NJUST</p>
 * @author 刘龙强
 * @date 2017-4-1
 */
public class User
{
	/**
	 * 用户ID，主键，自动递增型
	 */
	private int id;

	/**
	 * 用户姓名，NULL允许
	 */
	private String name;

	/**
	 * 用户性别，NULL允许
	 */
	private String sex;

	/**
	 * 用户年龄，NULL允许
	 */
	private String age;

	/**
	 * 用户电话，NULL允许
	 */
	private String tel;

	/**
	 * 用户地址，NULL允许
	 */
	private String address;

	/**
	 * 用户登录名，NULL允许
	 */
	private String loginName;

	/**
	 * 用户登录密码，NULL允许
	 */
	private String loginPw;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

}
