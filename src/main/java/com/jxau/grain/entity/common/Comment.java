package com.jxau.grain.entity.common;


import com.jxau.grain.annotion.ValidateEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 评论粮食实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="lssf_comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="peasant_id")
	private Peasant peasant;//所属用户
	
	@ManyToOne
	@JoinColumn(name="goods_id")
	private Goods goods;//评论的物品
	
	@ValidateEntity(required=true,requiredLeng=true,minLength=1,maxLength=1000,errorRequiredMsg="评论内容不能为空!",errorMinLengthMsg="评论内容长度需大于1!",errorMaxLengthMsg="评论内容长度不能大于1000!")
	@Column(name="content",nullable=false,length=1024)
	private String content;//评论内容
	
	
	@Column(name="reply_to",length=64)
	private String replyTo;//回复者


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

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"peasant=" + peasant +
				", goods=" + goods +
				", content='" + content + '\'' +
				", replyTo='" + replyTo + '\'' +
				'}';
	}
}
