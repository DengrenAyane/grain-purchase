package com.jxau.grain.service.common;


import com.jxau.grain.bean.PageBean;
import com.jxau.grain.dao.common.WantedGoodsDao;
import com.jxau.grain.entity.common.Peasant;
import com.jxau.grain.entity.common.WantedGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class WantedGoodsService {

	@Autowired
	private WantedGoodsDao wantedGoodsDao;
	
	/**
	 * 求购粮食信息添加/编辑（传入id则为编辑，否则是添加）
	 * @param wantedGoods
	 * @return
	 */
	public WantedGoods save(WantedGoods wantedGoods){
		return wantedGoodsDao.save(wantedGoods);
	}
	
	/**
	 * 根据农民查询
	 * @param peasant
	 * @return
	 */
	public List<WantedGoods> findByPeasant(Peasant peasant){
		return wantedGoodsDao.findByPeasant(peasant);
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public WantedGoods find(Long id){
		return wantedGoodsDao.find(id);
	}
	
	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Long id){
		wantedGoodsDao.deleteById(id);
	}
	
	/**
	 * 分页展示求购物品列表
	 * @param pageBean
	 * @param WantedGoods
	 * @return
	 */
	public PageBean<WantedGoods> findlist(PageBean<WantedGoods> pageBean, WantedGoods WantedGoods){
		ExampleMatcher exampleMatcher = ExampleMatcher.matching();
		exampleMatcher = exampleMatcher.withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
		exampleMatcher = exampleMatcher.withIgnorePaths("viewNumber");
		Example<WantedGoods> example = Example.of(WantedGoods, exampleMatcher);
		Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
		PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
		Page<WantedGoods> findAll = wantedGoodsDao.findAll(example, pageable);
		pageBean.setContent(findAll.getContent());
		pageBean.setTotal(findAll.getTotalElements());
		pageBean.setTotalPage(findAll.getTotalPages());
		return pageBean;
	}
	
	public PageBean<WantedGoods> findWantedGoodslist(PageBean<WantedGoods> pageBean,WantedGoods wantedGoods){
		
		Specification<WantedGoods> specification = new Specification<WantedGoods>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<WantedGoods> root,
										 CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				Predicate predicate = criteriaBuilder.like(root.get("name"), "%" + (wantedGoods.getName() == null ? "" : wantedGoods.getName()) + "%");
				if(wantedGoods.getPeasant() != null && wantedGoods.getPeasant().getId() != null){
					Predicate equal1 = criteriaBuilder.equal(root.get("student"), wantedGoods.getPeasant().getId());
					predicate = criteriaBuilder.and(predicate,equal1);
				}
				return predicate;
			}
		};
		Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
		PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
		Page<WantedGoods> findAll = wantedGoodsDao.findAll(specification, pageable);
		pageBean.setContent(findAll.getContent());
		pageBean.setTotal(findAll.getTotalElements());
		pageBean.setTotalPage(findAll.getTotalPages());
		return pageBean;
	}
	
	/**
	 * 求购粮食总数
	 * @return
	 */
	public long total(){
		return wantedGoodsDao.count();
	}
}
