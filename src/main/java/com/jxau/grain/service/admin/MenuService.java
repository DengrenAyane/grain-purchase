package com.jxau.grain.service.admin;

import com.jxau.grain.dao.admin.MenuDao;
import com.jxau.grain.entity.admin.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台菜单操作service
 */


@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	/**
	 * 菜单添加/编辑
	 * @param menu
	 * @return
	 */
	public Menu save(Menu menu){
		return menuDao.save(menu);
	}
	
	/**
	 * 获取所有的菜单列表
	 * @return
	 */
	public List<Menu> findAll(){
		return menuDao.findAll();
	}
	
	/**
	 * 根据id查询菜单
	 * @param id
	 * @return
	 */
	public Menu find(Long id){
		return menuDao.find(id);
	}
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 */
	public void delete(Long id){
		menuDao.deleteById(id);
	}
}
