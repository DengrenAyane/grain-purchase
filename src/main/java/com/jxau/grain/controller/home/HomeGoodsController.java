package com.jxau.grain.controller.home;


import com.jxau.grain.bean.PageBean;
import com.jxau.grain.bean.Result;
import com.jxau.grain.entity.common.Goods;
import com.jxau.grain.entity.common.GoodsCategory;
import com.jxau.grain.service.common.CommentService;
import com.jxau.grain.service.common.GoodsCategoryService;
import com.jxau.grain.service.common.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 前台粮食管理控制器
 * @author Administrator
 *
 */
@RequestMapping("/home/goods")
@Controller
public class HomeGoodsController {

	@Autowired
	private GoodsCategoryService goodsCategoryService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CommentService commentService;
	/**
	 * 粮食详情页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detail")
	public String detail(@RequestParam(name="id",required=true)Long id, Model model){
		Goods goods = goodsService.findById(id);
		if(goods == null){
			model.addAttribute("msg", "粮食不存在！");
			return "error/runtime_error";
		}
		model.addAttribute("goods", goods);
		model.addAttribute("commentList", commentService.findByGoods(goods));
		//更新商品浏览量
		goods.setViewNumber(goods.getViewNumber() + 1);
		goodsService.save(goods);
		return "home/goods/detail";
	}
	
	/**
	 * 根据粮食分类搜索粮食信息
	 * @param cid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String list(@RequestParam(name="cid",required=true)Long cid, PageBean<Goods> pageBean, Model model){
		GoodsCategory goodsCategory = goodsCategoryService.findById(cid);
		if(goodsCategory == null){
			model.addAttribute("msg", "粮食分类不存在！");
			return "error/runtime_error";
		}
		//接下来分两步来考虑，分类是否是二级分类。
		List<Long> ids = new ArrayList<Long>();
		ids.add(goodsCategory.getId());
		if(goodsCategory.getParent() == null){
			//选中的是顶级分类，此时需要获取该顶级分类下的所有子分类
			List<GoodsCategory> findChildren = goodsCategoryService.findChildren(goodsCategory);
			for(GoodsCategory gc : findChildren){
				ids.add(gc.getId());
			}
		}
		model.addAttribute("pageBean", goodsService.findlist(ids, pageBean));
		model.addAttribute("gc",goodsCategory);
		return "home/goods/list";
	}
	
	/**
	 * 获取已出售的商品总数
	 * @return
	 */
	@RequestMapping(value="/get_sold_total",method= RequestMethod.POST)
	@ResponseBody
	public Result<Long> getSoldTotal(){
		return Result.success(goodsService.getSoldTotalCount());
	}
}
