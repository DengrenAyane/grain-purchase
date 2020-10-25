package com.jxau.grain.controller.admin;


import com.jxau.grain.bean.PageBean;
import com.jxau.grain.bean.Result;
import com.jxau.grain.entity.common.Goods;
import com.jxau.grain.entity.common.ReportGoods;
import com.jxau.grain.entity.common.Peasant;
import com.jxau.grain.service.common.GoodsService;
import com.jxau.grain.service.common.ReportGoodsService;
import com.jxau.grain.service.common.PeasantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台粮食举报管理控制器
 * @author Administrator
 *
 */
@RequestMapping("/admin/report")
@Controller
public class ReportController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private PeasantService peasantService;
	@Autowired
	private ReportGoodsService reportGoodsService;
	
	/**
	 * 粮食举报管理列表页面
	 * @param reportGoods
	 * @param pageBean
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String list(ReportGoods reportGoods, PageBean<ReportGoods> pageBean, Model model){
		if(reportGoods.getPeasant() != null && reportGoods.getPeasant().getPn() != null){
			Peasant peasant = peasantService.findByPn(reportGoods.getPeasant().getPn());
			if(peasant != null){
				reportGoods.setPeasant(peasant);
			}
		}
		List<Goods> goodsList = null;
		if(reportGoods.getGoods() != null && reportGoods.getGoods().getName() != null){
			goodsList = goodsService.findListByName(reportGoods.getGoods().getName());
		}
		model.addAttribute("title", "物品举报列表");
		model.addAttribute("content", reportGoods.getContent());
		model.addAttribute("name", reportGoods.getGoods() == null ? null : reportGoods.getGoods().getName());
		model.addAttribute("pn", reportGoods.getPeasant() == null ? null : reportGoods.getPeasant().getPn());
		model.addAttribute("pageBean", reportGoodsService.findlist(pageBean, reportGoods,goodsList));
		return "admin/report/list";
	}
	
	

	
	/**
	 * 粮食举报删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){
		reportGoodsService.delete(id);
		return Result.success(true);
	}
}
