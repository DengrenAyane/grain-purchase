package com.jxau.grain.dao.admin;

import com.jxau.grain.entity.admin.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 后台角色数据库操作层
 */


@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
	@Query("select r from Role r where r.id = :id")
	Role find(@Param("id")Long id);
}
