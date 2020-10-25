package com.jxau.grain.service.common;

import com.jxau.grain.bean.PageBean;
import com.jxau.grain.dao.common.ReportGoodsDao;
import com.jxau.grain.entity.common.Goods;
import com.jxau.grain.entity.common.ReportGoods;
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
public class ReportGoodsService {

	@Autowired
	private ReportGoodsDao reportGoodsDao;
	
	/**
	 * 粮食添加/编辑，当id不为空时，则编辑
	 * @param reportGoods
	 * @return
	 */
	public ReportGoods save(ReportGoods reportGoods){
		return reportGoodsDao.save(reportGoods);
	}
	
	
	
	
	/**
	 * 粮食举报信息删除
	 * @param id
	 */
	public void delete(Long id){
		reportGoodsDao.deleteById(id);
	}
	
	
	
	/**
	 * 根据农民查找物品
	 * @param peasant
	 * @return
	 */
	public List<ReportGoods> findByPeasant(Peasant peasant){
		return reportGoodsDao.findByPeasant(peasant);
	}
	
	/**
	 * 根据农民id和粮食id查询
	 * @param goodsId
	 * @param peasantId
	 * @return
	 */
	public ReportGoods find(Long goodsId,Long peasantId){
		return reportGoodsDao.find(goodsId, peasantId);
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public ReportGoods find(Long id){
		return reportGoodsDao.find(id);
	}
	
	/**
	 * 粮食举报信息搜索
	 * @param pageBean
	 * @param reportGoods
	 * @param goodsList
	 * @return
	 */
	public PageBean<ReportGoods> findlist(PageBean<ReportGoods> pageBean, ReportGoods reportGoods, List<Goods> goodsList){
		
		Specification<ReportGoods> specification = new Specification<ReportGoods>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ReportGoods> root,
										 CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				Predicate predicate = criteriaBuilder.like(root.get("content"), "%" + (reportGoods.getContent() == null ? "" : reportGoods.getContent()) + "%");
				if(reportGoods.getPeasant() != null && reportGoods.getPeasant().getId() != null){
					Predicate eqal1 = criteriaBuilder.equal(root.get("peasant"), reportGoods.getPeasant().getId());
					predicate = criteriaBuilder.and(predicate,eqal1);
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
		Page<ReportGoods> findAll = reportGoodsDao.findAll(specification, pageable);
		pageBean.setContent(findAll.getContent());
		pageBean.setTotal(findAll.getTotalElements());
		pageBean.setTotalPage(findAll.getTotalPages());
		return pageBean;
	}
}
