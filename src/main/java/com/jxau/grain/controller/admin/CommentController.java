package com.jxau.grain.controller.admin;


import com.jxau.grain.bean.PageBean;
import com.jxau.grain.bean.Result;
import com.jxau.grain.entity.common.Comment;
import com.jxau.grain.entity.common.Goods;
import com.jxau.grain.entity.common.Peasant;
import com.jxau.grain.service.common.CommentService;
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
 * 后台粮食评论管理控制器
 * @author Administrator
 *
 */
@RequestMapping("/admin/comment")
@Controller
public class CommentController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private PeasantService peasantService;
	@Autowired
	private CommentService commentService;
	
	/**
	 * 物品评论管理列表页面
	 * @param comment
	 * @param pageBean
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String list(Comment comment, PageBean<Comment> pageBean, Model model){
		if(comment.getPeasant() != null && comment.getPeasant().getPn() != null){
			Peasant peasant = peasantService.findByPn(comment.getPeasant().getPn());
			if(peasant != null){
				comment.setPeasant(peasant);
			}
		}
		List<Goods> goodsList = null;
		if(comment.getGoods() != null && comment.getGoods().getName() != null){
			goodsList = goodsService.findListByName(comment.getGoods().getName());
		}
		model.addAttribute("title", "物品评论列表");
		model.addAttribute("content", comment.getContent());
		model.addAttribute("name", comment.getGoods() == null ? null : comment.getGoods().getName());
		model.addAttribute("pn", comment.getPeasant() == null ? null : comment.getPeasant().getPn());
		model.addAttribute("pageBean", commentService.findlist(pageBean, comment,goodsList));
		return "admin/comment/list";

	}
	
	

	
	/**
	 * 粮食评论删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> delete(@RequestParam(name="id",required=true)Long id){
		commentService.delete(id);
		return Result.success(true);
	}
}
