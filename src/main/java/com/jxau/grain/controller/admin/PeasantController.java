package com.jxau.grain.controller.admin;


import com.jxau.grain.bean.CodeMsg;
import com.jxau.grain.bean.PageBean;
import com.jxau.grain.bean.Result;
import com.jxau.grain.entity.common.Peasant;
import com.jxau.grain.service.common.PeasantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 后台农民用户管理控制器
 * @author Administrator
 *
 */
@RequestMapping("/admin/peasant")
@Controller
public class PeasantController {

	@Autowired
	private PeasantService peasantService;
	
	/**
	 * 农民管理列表页面
	 * @param peasant
	 * @param pageBean
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String list(Peasant peasant, PageBean<Peasant> pageBean, Model model){
		model.addAttribute("title", "农民列表");
		model.addAttribute("pn", peasant.getPn());
		model.addAttribute("pageBean", peasantService.findlist(pageBean, peasant));
		return "admin/peasant/list";
	}
	
	

	/**
	 * 农民用户状态编辑
	 * @param id,status
	 * @return
	 */
	@RequestMapping(value="/update_status",method= RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> upDown(@RequestParam(name="id",required=true)Long id , @RequestParam(name="status",required=true)Integer status){
		Peasant peasant = peasantService.findById(id);
		if(peasant == null){
			return Result.error(CodeMsg.ADMIN_GOODS_NO_EXIST);
		}
		if(peasant.getStatus() == status){
			return Result.error(CodeMsg.ADMIN_PEASANT_STATUS_NO_CHANGE);
		}
		if(status != Peasant.PEASANT_STATUS_ENABLE && status != Peasant.PEASANT_STATUS_UNABLE){
			return Result.error(CodeMsg.ADMIN_PEASANT_STATUS_ERROR);
		}
		peasant.setStatus(status);
		//进行更新数据库
		if(peasantService.save(peasant) ==null){
			return Result.error(CodeMsg.ADMIN_PEASANT_EDIT_ERROR);
		}
		return Result.success(true);
	}
	
	
	/**
	 * 农民用户删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){
		try {
			peasantService.delete(id);
		} catch (Exception e) {
			return Result.error(CodeMsg.ADMIN_PEASANT_DELETE_ERROR);
		}
		return Result.success(true);
	}
}
