package com.orm;

/**
 * <p>Description: 专家信息表</p>
 * <p>Company: NJUST</p>
 * @author 刘龙强
 * @date 2017-4-2
 */
public class Tzhuanjia
{
	/**
	 * 专家信息ID，主键，自动递增型
	 */
	private int id;

	/**
	 * 专家姓名
	 */
	private String name;

	/**
	 * 专家性别
	 */
	private String sex;

	/**
	 * 专家年龄
	 */
	private String age;

	/**
	 * 专家电话
	 */
	private String tel;

	/**
	 * 专家住址
	 */
	private String address;

	/**
	 * 专家登录名称
	 */
	private String loginName;

	/**
	 * 专家姓名登录密码
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
