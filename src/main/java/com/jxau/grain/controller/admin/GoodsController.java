package com.jxau.grain.controller.admin;


import com.jxau.grain.bean.CodeMsg;
import com.jxau.grain.bean.PageBean;
import com.jxau.grain.bean.Result;
import com.jxau.grain.dao.common.PeasantDao;
import com.jxau.grain.entity.common.Goods;
import com.jxau.grain.entity.common.GoodsCategory;
import com.jxau.grain.entity.common.Peasant;
import com.jxau.grain.service.common.GoodsCategoryService;
import com.jxau.grain.service.common.GoodsService;
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
 * 后台粮食管理控制器
 * @author Administrator
 *
 */
@RequestMapping("/admin/goods")
@Controller
public class GoodsController {

	@Autowired
	private GoodsCategoryService goodsCategoryService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private PeasantService peasantService;
	
	/**
	 * 粮食管理列表页面
	 * @param goods
	 * @param pageBean
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String list(Goods goods, PageBean<Goods> pageBean, Model model){
		if(goods.getPeasant() != null && goods.getPeasant().getPn() != null){
			Peasant peasant = peasantService.findByPn(goods.getPeasant().getPn());
			if(peasant != null){
				goods.setPeasant(peasant);
			}
		}
		if(goods.getGoodsCategory() != null && goods.getGoodsCategory().getName() != null){
			List<GoodsCategory> goodsCategorys = goodsCategoryService.findByName(goods.getGoodsCategory().getName());
			if(goodsCategorys != null && goodsCategorys.size() > 0){
				goods.setGoodsCategory(goodsCategorys.get(0));
			}
		}
		goods.setStatus(-1);
		model.addAttribute("title", "物品列表");
		model.addAttribute("name", goods.getName());
		model.addAttribute("goodsCategoryName", goods.getGoodsCategory() == null ? null : goods.getGoodsCategory().getName());
		model.addAttribute("pn", goods.getPeasant() == null ? null : goods.getPeasant().getPn());
		model.addAttribute("pageBean", goodsService.findlist(pageBean, goods));
		return "admin/goods/list";
	}
	
	

	/**
	 * 粮食上架
	 * @param id,status
	 * @return
	 */
	@RequestMapping(value="/up_down",method= RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> upDown(@RequestParam(name="id",required=true)Long id , @RequestParam(name="status",required=true)Integer status){
		Goods goods = goodsService.findById(id);
		if(goods == null){
			return Result.error(CodeMsg.ADMIN_GOODS_NO_EXIST);
		}
		if(goods.getStatus() == status){
			return Result.error(CodeMsg.ADMIN_GOODS_STATUS_NO_CHANGE);
		}
		if(status != Goods.GOODS_STATUS_UP && status != Goods.GOODS_STATUS_DOWN){
			return Result.error(CodeMsg.ADMIN_GOODS_STATUS_ERROR);
		}
		if(goods.getStatus() == Goods.GOODS_STATUS_SOLD){
			return Result.error(CodeMsg.ADMIN_GOODS_STATUS_UNABLE);
		}
		goods.setStatus(status);
		//进行更新数据库
		if(goodsService.save(goods) ==null){
			return Result.error(CodeMsg.ADMIN_GOODS_EDIT_ERROR);
		}
		return Result.success(true);
	}
	
	/**
	 * 粮食推荐或取消推荐
	 * @param id
	 * @param recommend
	 * @return
	 */
	@RequestMapping(value="/recommend",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> recommend(@RequestParam(name="id",required=true)Long id ,@RequestParam(name="recommend",required=true)Integer recommend){
		Goods goods = goodsService.findById(id);
		if(goods == null){
			return Result.error(CodeMsg.ADMIN_GOODS_NO_EXIST);
		}
		if(goods.getRecommend() == recommend){
			return Result.error(CodeMsg.ADMIN_GOODS_STATUS_NO_CHANGE);
		}
		if(recommend != Goods.GOODS_RECOMMEND_OFF && recommend != Goods.GOODS_RECOMMEND_ON){
			return Result.error(CodeMsg.ADMIN_GOODS_STATUS_ERROR);
		}
		if(goods.getStatus() == Goods.GOODS_STATUS_SOLD){
			return Result.error(CodeMsg.ADMIN_GOODS_STATUS_UNABLE);
		}
		goods.setRecommend(recommend);;
		//进行更新数据库
		if(goodsService.save(goods) ==null){
			return Result.error(CodeMsg.ADMIN_GOODS_EDIT_ERROR);
		}
		return Result.success(true);
	}
	
	
	
	/**
	 * 粮食删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){
		try {
			goodsService.delete(id);
		} catch (Exception e) {
			return Result.error(CodeMsg.ADMIN_GOODS_DELETE_ERROR);
		}
		return Result.success(true);
	}
}
