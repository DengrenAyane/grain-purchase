package com.jxau.grain.entity.common;


import com.jxau.grain.annotion.ValidateEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * 农民实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="lssf_peasant")
@EntityListeners(AuditingEntityListener.class)
public class Peasant extends BaseEntity{

	public static final int PEASANT_STATUS_ENABLE = 1;//状态可用
	public static final int PEASANT_STATUS_UNABLE = 0;//状态不可用
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=6,maxLength=18,errorRequiredMsg="学号不能为空!",errorMinLengthMsg="学号长度需大于6!",errorMaxLengthMsg="学号长度不能大于18!")
	@Column(name="pn",nullable=false,length=18,unique=true)
	private String pn;//农民id
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=6,maxLength=18,errorRequiredMsg="密码不能为空!",errorMinLengthMsg="密码长度需大于6!",errorMaxLengthMsg="密码长度不能大于18!")
	@Column(name="password",nullable=false,length=18)
	private String password;//农民登录密码
	
	@ValidateEntity(required=false)
	@Column(name="head_pic",length=128)
	private String headPic;//农民头像
	
	@ValidateEntity(required=false)
	@Column(name="nickname",length=32)
	private String nickname;//昵称
	
	@ValidateEntity(required=false)
	@Column(name="mobile",length=18)
	private String mobile;//手机号
	
	@ValidateEntity(required=true,minLength=5,maxLength=12,errorMinLengthMsg="qq号最小5位",errorMaxLengthMsg="qq号长度不能大于12")
	@Column(name="qq",length=18)
	private String qq;//QQ号
	
	@ValidateEntity(required=false)
	@Column(name="status",length=1)
	private int status = PEASANT_STATUS_ENABLE;//农民状态，默认可用


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Peasant{" +
				"pn='" + pn + '\'' +
				", password='" + password + '\'' +
				", headPic='" + headPic + '\'' +
				", nickname='" + nickname + '\'' +
				", mobile='" + mobile + '\'' +
				", qq='" + qq + '\'' +
				", status=" + status +
				'}';
	}
}
