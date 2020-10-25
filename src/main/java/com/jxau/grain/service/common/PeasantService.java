package com.jxau.grain.service.common;

import com.jxau.grain.bean.PageBean;
import com.jxau.grain.dao.common.PeasantDao;
import com.jxau.grain.entity.common.Peasant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * 粮食信息操作service
 */


@Service
public class PeasantService {

	@Autowired
	private PeasantDao peasantDao;
	
	/**
	 * 根据农民ID查询
	 * @param pn
	 * @return
	 */
	public Peasant findByPn(String pn){
		return peasantDao.findByPn(pn);
	}
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public Peasant findById(Long id){
		return peasantDao.find(id);
	}
	
	/**
	 * 用户修改/编辑，当传入id时则为编辑，若id为空则为添加
	 * @param peasant
	 * @return
	 */
	public Peasant save(Peasant peasant){
		return peasantDao.save(peasant);
	}
	
	/**
	 * 搜索用户列表
	 * @param pageBean
	 * @param peasant
	 * @return
	 */
	public PageBean<Peasant> findlist(PageBean<Peasant> pageBean, Peasant peasant){
		ExampleMatcher exampleMatcher = ExampleMatcher.matching();
		exampleMatcher = exampleMatcher.withMatcher("sn", ExampleMatcher.GenericPropertyMatchers.contains());
		exampleMatcher = exampleMatcher.withIgnorePaths("status");
		Example<Peasant> example = Example.of(peasant, exampleMatcher);
		Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
		PageRequest pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize(), sort);
		Page<Peasant> findAll = peasantDao.findAll(example, pageable);
		pageBean.setContent(findAll.getContent());
		pageBean.setTotal(findAll.getTotalElements());
		pageBean.setTotalPage(findAll.getTotalPages());
		return pageBean;
	}
	
	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Long id){
		peasantDao.deleteById(id);
	}
	
	/**
	 * 获取粮食总数
	 * @return
	 */
	public long total(){
		return peasantDao.count();
	}
}
