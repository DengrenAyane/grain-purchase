package com.jxau.grain.entity.common;


import com.jxau.grain.annotion.ValidateEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 举报粮食实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="lssf_report_goods")
@EntityListeners(AuditingEntityListener.class)
public class ReportGoods extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="peasant_id")
	private Peasant peasant;//所属农民
	
	@ManyToOne
	@JoinColumn(name="goods_id")
	private Goods goods;//举报的粮食
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=1000,errorRequiredMsg="举报原因不能为空!",errorMinLengthMsg="举报原因长度需大于1!",errorMaxLengthMsg="举报原因长度不能大于1000!")
	@Column(name="content",nullable=false,length=1024)
	private String content;//举报原因

	public Peasant getPeasant() {
		return peasant;
	}

	public void setPeasant(Peasant peasant) {
		this.peasant = peasant;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReportGoods{" +
				"peasant=" + peasant +
				", goods=" + goods +
				", content='" + content + '\'' +
				'}';
	}
}
