package com.jxau.grain.service.common;


import com.jxau.grain.bean.PageBean;
import com.jxau.grain.dao.common.CommentDao;
import com.jxau.grain.entity.common.Comment;
import com.jxau.grain.entity.common.Goods;
import com.jxau.grain.entity.common.Peasant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	/**
	 * 添加/编辑，当id不为空时，则编辑
	 * @param comment
	 * @return
	 */
	public Comment save(Comment comment){
		return commentDao.save(comment);
	}
	
	/**
	 * 评论信息删除
	 * @param id
	 */
	public void delete(Long id){
		commentDao.deleteById(id);
	}

	/**
	 * 根据用户查找物品
	 * @param peasant
	 * @return
	 */
	public List<Comment> findByPeasant(Peasant peasant){
		return commentDao.findByPeasant(peasant);
	}
	
	/**
	 * 根据粮食查找
	 * @param goods
	 * @return
	 */
	public List<Comment> findByGoods(Goods goods){
		return commentDao.findByGoods(goods);
	}
	
	/**
	 * 根据用户id和粮食id查询
	 * @param goodsId
	 * @param peasantId
	 * @return
	 */
	public Comment find(Long goodsId,Long peasantId){
		return commentDao.find(goodsId, peasantId);
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Comment find(Long id){
		return commentDao.find(id);
	}
	
	/**
	 * 多条件搜索物品评论
	 * @param pageBean
	 * @param comment
	 * @param goodsList
	 * @return
	 */
	public PageBean<Comment> findlist(PageBean<Comment> pageBean, Comment comment, List<Goods> goodsList){
		
		Specification<Comment> specification = new Specification<Comment>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Comment> root,
										 CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				Predicate predicate = criteriaBuilder.like(root.get("content"), "%" + (comment.getContent() == null ? "" : comment.getContent()) + "%");
				if(comment.getPeasant() != null && comment.getPeasant().getId() != null){
					Predicate equal1 = criteriaBuilder.equal(root.get("peasant"), comment.getPeasant().getId());
					predicate = criteriaBuilder.and(predicate,equal1);
				}
				if(goodsList != null && goodsList.size() >0 ){
					CriteriaBuilder.In<Object> in = criteriaBuilder.in(root.get("goods"));
					in.value(goodsList);
					predicate = criteriaBuilder.and(predicate,in);
				}
				return predicate;
			}
		};
		Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
		PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
		Page<Comment> findAll = commentDao.findAll(specification, pageable);
		pageBean.setContent(findAll.getContent());
		pageBean.setTotal(findAll.getTotalElements());
		pageBean.setTotalPage(findAll.getTotalPages());
		return pageBean;
	}
	
	/**
	 * 获取评论总数
	 * @return
	 */
	public long total(){
		return commentDao.count();
	}
}
