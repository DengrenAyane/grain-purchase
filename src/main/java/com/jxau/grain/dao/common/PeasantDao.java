package com.jxau.grain.dao.common;

import com.jxau.grain.entity.common.Peasant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 农民信息操作dao类
 */

@Repository
public interface PeasantDao extends JpaRepository<Peasant, Long> {
	
	/**
	 * 根据用户ID查询
	 * @param pn
	 * @return
	 */
	Peasant findByPn(String pn);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	@Query("select s from Peasant s where id = :id")
    Peasant find(@Param("id")Long id);
}
