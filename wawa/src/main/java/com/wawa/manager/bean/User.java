package com.wawa.manager.bean;

import java.sql.Date;

import com.wawa.basic.bean.BasicBean;

/**
 * 用户属性
 * 
 * @author Yang Xiaodong 2013年12月3日 下午10:34:45
 */
public class User extends BasicBean {

	private static final long serialVersionUID = -4578458436524623472L;
	/**
	 * 用户名称 VARCHAR(32)
	 */
	private String account;
	/**
	 * 秘密 VARCHAR(32)
	 */
	private String password;

	/**
	 * 用户类型 INT(2) 1：普通用户
	 */
	private Integer acctp;
	/**
	 * 真实姓名 VARCHAR(16)
	 */
	private String realname;
	/**
	 * 昵称 VARCHAR(16)
	 */
	private String nickname;
	/**
	 * 称谓 INT(2) 1：爸爸 2：妈妈 3：爷爷 4：奶奶 5：外公：6 外婆 7：叔叔 8：阿姨 9：哥哥 10：姐姐
	 */
	private Integer title;
	/**
	 * 邮件 VARCHAR(64)
	 */
	private String email;
	/**
	 * 电话 VARCHAR(32)
	 */
	private String mobile;
	/**
	 * QQ号码 VARCHAR(32)
	 */
	private String qq;
	/**
	 * 微信号码 VARCHAR(32)
	 */
	private String weixin;
	/**
	 * 微博类型 INT(2) 1:新浪 2：腾讯
	 */
	private Integer weibotp;
	/**
	 * 微博号码 VARCHAR(32)
	 */
	private String weibo;
	/**
	 * 生日 VARCHAR(32)
	 */
	private String birthday;
	/**
	 * 通讯地址 VARCHAR(64)
	 */
	private String address;

	/**
	 * 创建时间 timestamp
	 */
	private Date createtime;

	/**
	 * 更新时间 timestamp
	 */ 
	private Date updatetime;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAcctp() {
		return acctp;
	}

	public void setAcctp(Integer acctp) {
		this.acctp = acctp;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getTitle() {
		return title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public Integer getWeibotp() {
		return weibotp;
	}

	public void setWeibotp(Integer weibotp) {
		this.weibotp = weibotp;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}
