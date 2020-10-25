package com.jxau.grain.dao.admin;

import com.jxau.grain.entity.admin.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 后台菜单数据库操作层
 */


//JpaRepository里面有很多做好的sql方法，可以直接调用
@Repository
public interface MenuDao extends JpaRepository<Menu, Long> {
	@Query("select m from Menu m where m.id = :id")
	Menu find(@Param("id")Long id);
}
