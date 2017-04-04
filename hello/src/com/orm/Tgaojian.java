package com.orm;

/**
 * <p>Description: 稿件表</p>
 * <p>Company: NJUST</p>
 * @author 刘龙强
 * @date 2017-4-2
 */
public class Tgaojian
{
	/**
	 * 稿件ID，主键，自动递增型
	 */
	private int id;
	
	/**
	 * 文章标题
	 */
	private String title;
	
	/**
	 * 文章内容
	 */
	private String content;
	
	/**
	 * 附件路径：/upload/xxxx.doc
	 */
	private String fujian;
	
	/**
	 * 附件原始名称：附件.doc
	 */
	private String fujianYuanshiming;
	
	/**
	 * 提交时间
	 */
	private String shijian;
	
	/**
	 * 关联用户ID
	 */
	private int user_id;
	
	/**
	 * 专家审核标志：
	 * 审核中/审核通过/审核未通过
	 */
	private String zhuanjiashenhebiaozhi;//shenhezhong,shenhetongguo,shenhetongguono
	
	/**
	 * 专家审核意见
	 */
	private String zhuanjiashenheyijian;
	
	/**
	 * 主编审核标志：
	 */
	private String zhubianshenhebiaozhi;
	
	/**
	 * 主编审核意见
	 */
	private String zhubianshenheyijian;
	
	/**
	 * 是否发表标识符
	 */
	private String shifoufabiao;
	
	/**
	 * 删除标识符
	 */
	private String del;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFujian() {
		return fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	public String getFujianYuanshiming() {
		return fujianYuanshiming;
	}

	public void setFujianYuanshiming(String fujianYuanshiming) {
		this.fujianYuanshiming = fujianYuanshiming;
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

	public String getZhuanjiashenhebiaozhi() {
		return zhuanjiashenhebiaozhi;
	}

	public void setZhuanjiashenhebiaozhi(String zhuanjiashenhebiaozhi) {
		this.zhuanjiashenhebiaozhi = zhuanjiashenhebiaozhi;
	}

	public String getZhuanjiashenheyijian() {
		return zhuanjiashenheyijian;
	}

	public void setZhuanjiashenheyijian(String zhuanjiashenheyijian) {
		this.zhuanjiashenheyijian = zhuanjiashenheyijian;
	}

	public String getZhubianshenhebiaozhi() {
		return zhubianshenhebiaozhi;
	}

	public void setZhubianshenhebiaozhi(String zhubianshenhebiaozhi) {
		this.zhubianshenhebiaozhi = zhubianshenhebiaozhi;
	}

	public String getZhubianshenheyijian() {
		return zhubianshenheyijian;
	}

	public void setZhubianshenheyijian(String zhubianshenheyijian) {
		this.zhubianshenheyijian = zhubianshenheyijian;
	}

	public String getShifoufabiao() {
		return shifoufabiao;
	}

	public void setShifoufabiao(String shifoufabiao) {
		this.shifoufabiao = shifoufabiao;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}
	
}
