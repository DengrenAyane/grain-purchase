package com.jxau.grain.service.common;


import com.jxau.grain.bean.PageBean;
import com.jxau.grain.dao.common.GoodsDao;
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
public class GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 粮食添加/编辑，当id不为空时，则编辑
	 * @param goods
	 * @return
	 */
	public Goods save(Goods goods){
		return goodsDao.save(goods);
	}
	
	
	/**
	 * 搜索分类列表
	 * @param pageBean
	 * @param goods
	 * @return
	 */
	public PageBean<Goods> findlist(PageBean<Goods> pageBean, Goods goods){
		
		Specification<Goods> specification = new Specification<Goods>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Goods> root,
										 CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				Predicate predicate = criteriaBuilder.like(root.get("name"), "%" + (goods.getName() == null ? "" : goods.getName()) + "%");
				if(goods.getPeasant() != null && goods.getPeasant().getId() != null){
					Predicate equal1 = criteriaBuilder.equal(root.get("peasant"), goods.getPeasant().getId());
					predicate = criteriaBuilder.and(predicate,equal1);
				}
				if(goods.getStatus() != -1){
					Predicate equal2 = criteriaBuilder.equal(root.get("status"), goods.getStatus());
					predicate = criteriaBuilder.and(predicate,equal2);
				}
				if(goods.getGoodsCategory() != null && goods.getGoodsCategory().getId() != null){
					Predicate equal2 = criteriaBuilder.equal(root.get("goodsCategory"), goods.getGoodsCategory().getId());
					predicate = criteriaBuilder.and(predicate,equal2);
				}
				return predicate;
			}
		};
		Sort sort = Sort.by(Sort.Direction.DESC, "createTime","recommend","flag","viewNumber");
		PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
		Page<Goods> findAll = goodsDao.findAll(specification, pageable);
		pageBean.setContent(findAll.getContent());
		pageBean.setTotal(findAll.getTotalElements());
		pageBean.setTotalPage(findAll.getTotalPages());
		return pageBean;
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Goods findById(Long id){
		return goodsDao.find(id);
	}
	
	/**
	 * 粮食分类删除
	 * @param id
	 */
	public void delete(Long id){
		goodsDao.deleteById(id);
	}
	
	/**
	 * 获取所有的物品
	 * @return
	 */
	public List<Goods> findAll(){
		return goodsDao.findAll();
	}
	
	/**
	 * 根据用户查找物品
	 * @param peasant
	 * @return
	 */
	public List<Goods> findByPeasant(Peasant peasant){
		return goodsDao.findByPeasant(peasant);
	}
	
	/**
	 * 根据用户id和物品id查询
	 * @param id
	 * @param peasantId
	 * @return
	 */
	public Goods find(Long id,Long peasantId){
		return goodsDao.find(id, peasantId);
	}
	
	/**
	 * 根据粮食分类查询列表
	 * @param cids
	 * @param pageBean
	 * @return
	 */
	public PageBean<Goods> findlist(List<Long> cids,PageBean<Goods> pageBean){
		List<Goods> findList = goodsDao.findList(cids,pageBean.getOffset(), pageBean.getPageSize());
		pageBean.setContent(findList);
		pageBean.setTotal(goodsDao.getTotalCount(cids));
		pageBean.setTotalPage(Integer.valueOf(pageBean.getTotal() / pageBean.getPageSize()+""));
		long totalPage = pageBean.getTotal() % pageBean.getPageSize();
		if(totalPage != 0){
			pageBean.setTotalPage(pageBean.getTotalPage() + 1);
		}
		return pageBean;
	}
	
	/**
	 * 获取指定状态的粮食总数
	 * @param status
	 * @return
	 */
	public Long getTotalCount(Integer status){
		return goodsDao.getTotalCount(status);
	}
	
	/**
	 * 获取已出售的粮食总数
	 * @return
	 */
	public Long getSoldTotalCount(){
		return getTotalCount(Goods.GOODS_STATUS_SOLD);
	}
	
	/**
	 * 根据粮食名称模糊搜索
	 * @param name
	 * @return
	 */
	public List<Goods> findListByName(String name){
		return goodsDao.findListByName(name);
	}
	
	/**
	 * 获取粮食总数
	 * @return
	 */
	public long total(){
		return goodsDao.count();
	}
}
