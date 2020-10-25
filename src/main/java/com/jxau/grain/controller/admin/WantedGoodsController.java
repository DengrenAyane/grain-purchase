package com.jxau.grain.controller.admin;


import com.jxau.grain.bean.PageBean;
import com.jxau.grain.bean.Result;
import com.jxau.grain.entity.common.Peasant;
import com.jxau.grain.entity.common.WantedGoods;
import com.jxau.grain.service.common.PeasantService;
import com.jxau.grain.service.common.WantedGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 后台求购粮食管理控制器
 * @author Administrator
 *
 */
@RequestMapping("/admin/wanted_goods")
@Controller
public class WantedGoodsController {

	@Autowired
	private WantedGoodsService wantedGoodsService;
	@Autowired
	private PeasantService peasantService;
	
	/**
	 * 求购粮食管理列表页面
	 * @param wantedGoods
	 * @param pageBean
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String list(WantedGoods wantedGoods, PageBean<WantedGoods> pageBean, Model model){
		if(wantedGoods.getPeasant() != null && wantedGoods.getPeasant().getPn() != null){
			Peasant student = peasantService.findByPn(wantedGoods.getPeasant().getPn());
			if(student != null){
				wantedGoods.setPeasant(student);
			}
		}
		model.addAttribute("title", "求购粮食列表");
		model.addAttribute("name", wantedGoods.getName());
		model.addAttribute("pn", wantedGoods.getPeasant() == null ? null : wantedGoods.getPeasant().getPn());
		model.addAttribute("pageBean", wantedGoodsService.findWantedGoodslist(pageBean, wantedGoods));
		return "admin/wanted_goods/list";
	}
	
	/**
	 * 求购粮食删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){
		wantedGoodsService.delete(id);
		return Result.success(true);
	}
}
