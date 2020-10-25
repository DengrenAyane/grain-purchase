package com.jxau.grain.dao.common;


import com.jxau.grain.entity.common.Peasant;
import com.jxau.grain.entity.common.WantedGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WantedGoodsDao extends JpaRepository<WantedGoods, Long>, JpaSpecificationExecutor<WantedGoods> {
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	@Query("select wg from WantedGoods wg where id = :id")
	WantedGoods find(@Param("id")Long id);
	
	/**
	 * 根据用户信息查询
	 * @param peasant
	 * @return
	 */
	public List<WantedGoods> findByPeasant(Peasant peasant);
}
