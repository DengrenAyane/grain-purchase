package com.jxau.grain.entity.common;


import com.jxau.grain.annotion.ValidateEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 粮食实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="lssf_goods")
@EntityListeners(AuditingEntityListener.class)
public class Goods extends BaseEntity{

	public static final int GOODS_STATUS_UP = 1;//上架
	public static final int GOODS_STATUS_DOWN = 2;//下架
	public static final int GOODS_STATUS_SOLD = 3;//已售出
	
	public static final int GOODS_FLAG_ON = 1;//擦亮
	public static final int GOODS_FLAG_OFF = 0;//不擦亮

	public static final int GOODS_RECOMMEND_OFF = 0;//不推荐
	public static final int GOODS_RECOMMEND_ON = 1;//推荐
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="peasant_id")
	private Peasant peasant;//所属农民
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=30,errorRequiredMsg="物品名称不能为空!",errorMinLengthMsg="物品名称长度需大于1!",errorMaxLengthMsg="物品名称长度不能大于30!")
	@Column(name="name",nullable=false,length=32)
	private String name;//物品名称
	
	@ManyToOne
	@JoinColumn(name="goods_category_id")
	private GoodsCategory goodsCategory;//粮食分类
	
	@ValidateEntity(required=true,errorRequiredMsg="请填写出售价格",requiredMinValue=true,errorMinValueMsg="出售价格不能小于0")
	@Column(name="sell_price",nullable=false,length=8)
	private Float sellPrice;//出售价格
	
	@ValidateEntity(required=true,errorRequiredMsg="请上传图片")
	@Column(name="photo",nullable=false,length=128)
	private String photo;//物品图片
	
	@Column(name="status",nullable=false,length=1)
	private int status = GOODS_STATUS_UP;//物品状态，默认上架
	
	@Column(name="flag",nullable=false,length=1)
	private int flag = GOODS_FLAG_OFF;//是否擦亮
	
	@Column(name="recommend",nullable=false,length=1)
	private int recommend = GOODS_RECOMMEND_OFF;//是否推荐
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=1000,errorRequiredMsg="物品详情描述不能为空!",errorMinLengthMsg="物品详情描述长度需大于1!",errorMaxLengthMsg="物品详情描述长度不能大于1000!")
	@Column(name="content",nullable=false,length=1024)
	private String content;//物品详情描述
	
	@Column(name="view_number",nullable=false,length=8)
	private int viewNumber = 0;//物品浏览量

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GoodsCategory getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(GoodsCategory goodsCategory) {
		this.goodsCategory = goodsCategory;
	}


	public Float getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Float sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Peasant getPeasant() {
		return peasant;
	}

	public void setPeasant(Peasant peasant) {
		this.peasant = peasant;
	}

	public int getViewNumber() {
		return viewNumber;
	}

	public void setViewNumber(int viewNumber) {
		this.viewNumber = viewNumber;
	}

	@Override
	public String toString() {
		return "Goods{" +
				"peasant=" + peasant +
				", name='" + name + '\'' +
				", goodsCategory=" + goodsCategory +
				", sellPrice=" + sellPrice +
				", photo='" + photo + '\'' +
				", status=" + status +
				", flag=" + flag +
				", recommend=" + recommend +
				", content='" + content + '\'' +
				", viewNumber=" + viewNumber +
				'}';
	}
}
