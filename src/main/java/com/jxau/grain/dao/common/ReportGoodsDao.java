package com.jxau.grain.dao.common;


import com.jxau.grain.entity.common.Goods;
import com.jxau.grain.entity.common.ReportGoods;
import com.jxau.grain.entity.common.Peasant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportGoodsDao extends JpaRepository<ReportGoods, Long>, JpaSpecificationExecutor<ReportGoods> {
	/**
	 * 根据id获取
	 * @return
	 */
	@Query("select rg from ReportGoods rg where id = :id")
	ReportGoods find(@Param("id")Long id);
	
	/**
	 * 根据农民查询
	 * @param peasant
	 * @return
	 */
	List<ReportGoods> findByPeasant(Peasant peasant);
	
	/**
	 * 根据粮食查询
	 * @param goods
	 * @return
	 */
	List<ReportGoods> findByGoods(Goods goods);
	
	/**
	 * 根据农民id和粮食id查询
	 * @param peasantId
	 * @param goodsId
	 * @return
	 */
	@Query("select rg from ReportGoods rg where rg.goods.id = :goodsId and rg.peasant.id = :peasantId")
	ReportGoods find(@Param("goodsId")Long goodsId,@Param("peasantId")Long peasantId);
	
	
}
