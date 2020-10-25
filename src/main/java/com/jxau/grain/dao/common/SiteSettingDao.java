package com.jxau.grain.dao.common;


import com.jxau.grain.entity.common.SiteSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 网站设置dao层
 */
@Repository
public interface SiteSettingDao extends JpaRepository<SiteSetting, Long> {
	
	/**
	 * 根据id查找
	 * @return
	 */
	@Query("select ss from SiteSetting ss where id = 1")
	SiteSetting find();
}
