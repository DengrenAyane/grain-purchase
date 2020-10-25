package com.jxau.grain.dao.common;


import com.jxau.grain.entity.common.Comment;
import com.jxau.grain.entity.common.Goods;
import com.jxau.grain.entity.common.Peasant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
	/**
	 * 根据id获取
	 * @return
	 */
	@Query("select c from Comment c where id = :id")
	Comment find(@Param("id")Long id);
	
	/**
	 * 根据用户查询
	 * @param peasant
	 * @return
	 */
	List<Comment> findByPeasant(Peasant peasant);
	
	/**
	 * 根据粮食查询
	 * @param goods
	 * @return
	 */
	List<Comment> findByGoods(Goods goods);
	
	/**
	 * 根据农民用户id和粮食id查询
	 * @param peasantId
	 * @param goodsId
	 * @return
	 */
	@Query("select c from Comment c where c.goods.id = :goodsId and c.peasant.id = :peasantId")
	Comment find(@Param("goodsId")Long goodsId,@Param("peasantId")Long peasantId);
	
	
}
