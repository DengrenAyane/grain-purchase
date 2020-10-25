package com.jxau.grain.controller.home;


import com.jxau.grain.bean.CodeMsg;
import com.jxau.grain.bean.Result;
import com.jxau.grain.constant.SessionConstant;
import com.jxau.grain.entity.common.*;
import com.jxau.grain.service.common.*;
import com.jxau.grain.util.SessionUtil;
import com.jxau.grain.util.ValidateEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生中心控制器
 * @author Administrator
 *
 */
@RequestMapping("/home/peasant")
@Controller
public class HomePeasantController {

	@Autowired
	private GoodsCategoryService goodsCategoryService;

	@Autowired
	private PeasantService peasantService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private WantedGoodsService wantedGoodsService;

	@Autowired
	private ReportGoodsService reportGoodsService;

	@Autowired
	private CommentService commentService;

	/**
	 * 学生登录主页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index",method= RequestMethod.GET)
	public String index(Model model){
		Peasant loginedPeasant = (Peasant) SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		model.addAttribute("goodsList", goodsService.findByPeasant(loginedPeasant));
		model.addAttribute("wantedGoodsList", wantedGoodsService.findByPeasant(loginedPeasant));
		model.addAttribute("reportGoodsList", reportGoodsService.findByPeasant(loginedPeasant));
		return "home/peasant/index";
	}
	
	/**
	 * 修改个人信息提交表单
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/edit_info",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> editInfo(Peasant student){
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		loginedPeasant.setMobile(student.getMobile());
		loginedPeasant.setNickname(student.getNickname());
		loginedPeasant.setQq(student.getQq());
		if(peasantService.save(loginedPeasant) == null){
			return Result.error(CodeMsg.HOME_PEASANT_EDITINFO_ERROR);
		}
		SessionUtil.set(SessionConstant.SESSION_PEASANT_LOGIN_KEY,loginedPeasant);
		return Result.success(true);
	}
	
	/**
	 * 保存用户头像
	 * @param headPic
	 * @return
	 */
	@RequestMapping(value="/update_head_pic",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> updateHeadPic(@RequestParam(name="headPic",required=true)String headPic){
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		loginedPeasant.setHeadPic(headPic);;
		if(peasantService.save(loginedPeasant) == null){
			return Result.error(CodeMsg.HOME_PEASANT_EDITINFO_ERROR);
		}
		SessionUtil.set(SessionConstant.SESSION_PEASANT_LOGIN_KEY,loginedPeasant);
		return Result.success(true);
	}
	
	/**
	 * 物品发布页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/publish",method=RequestMethod.GET)
	public String publish(Model model){
		return "home/peasant/publish";
	}
	
	/**
	 * 商品发布表单提交
	 * @param goods
	 * @return
	 */
	@RequestMapping(value="/publish",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> publish(Goods goods){
		CodeMsg validate = ValidateEntityUtil.validate(goods);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
			return Result.error(validate);
		}
		if(goods.getGoodsCategory() == null || goods.getGoodsCategory().getId() == null || goods.getGoodsCategory().getId().longValue() == -1){
			return Result.error(CodeMsg.HOME_PEASANT_PUBLISH_CATEGORY_EMPTY);
		}
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		goods.setPeasant(loginedPeasant);
		if(goodsService.save(goods) == null){
			return Result.error(CodeMsg.HOME_PEASANT_PUBLISH_ERROR);
		}
		return Result.success(true);
	}
	
	/**
	 * 物品编辑页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit_goods",method=RequestMethod.GET)
	public String publish(@RequestParam(name="id",required=true)Long id,Model model){
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		Goods goods = goodsService.find(id, loginedPeasant.getId());
		if(goods == null){
			model.addAttribute("msg", "物品不存在！");
			return "error/runtime_error";
		}
		model.addAttribute("goods", goods);
		return "home/peasant/edit_goods";
	}
	
	/**
	 * 物品编辑表单提交
	 * @param goods
	 * @return
	 */
	@RequestMapping(value="/edit_goods",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> editGoods(Goods goods){
		CodeMsg validate = ValidateEntityUtil.validate(goods);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
			return Result.error(validate);
		}
		if(goods.getGoodsCategory() == null || goods.getGoodsCategory().getId() == null || goods.getGoodsCategory().getId().longValue() == -1){
			return Result.error(CodeMsg.HOME_PEASANT_PUBLISH_CATEGORY_EMPTY);
		}
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		Goods existGoods = goodsService.find(goods.getId(), loginedPeasant.getId());
		if(existGoods == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		/*existGoods.setBuyPrice(goods.getBuyPrice());*/
		existGoods.setContent(goods.getContent());
		existGoods.setGoodsCategory(goods.getGoodsCategory());
		existGoods.setName(goods.getName());
		existGoods.setPhoto(goods.getPhoto());
		existGoods.setSellPrice(goods.getSellPrice());
		if(goodsService.save(existGoods) == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_EDIT_ERROR);
		}
		return Result.success(true);
	}
	
	/**
	 * 用户设置是否擦亮物品
	 * @param id
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/update_flag",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> updateFlag(@RequestParam(name="id",required=true)Long id,
			@RequestParam(name="flag",required=true,defaultValue="0")Integer flag){
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		Goods existGoods = goodsService.find(id, loginedPeasant.getId());
		if(existGoods == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		existGoods.setFlag(flag);
		if(goodsService.save(existGoods) == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_EDIT_ERROR);
		}
		return Result.success(true);
	}
	
	/**
	 * 修改物品状态
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/update_status",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> updateStatus(@RequestParam(name="id",required=true)Long id,
			@RequestParam(name="status",required=true,defaultValue="2")Integer status){
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		Goods existGoods = goodsService.find(id, loginedPeasant.getId());
		if(existGoods == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		existGoods.setStatus(status);
		if(goodsService.save(existGoods) == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_EDIT_ERROR);
		}
		return Result.success(true);
	}
	
	/**
	 * 发布求购物品页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/publish_wanted",method=RequestMethod.GET)
	public String publishWanted(Model model){
		return "home/peasant/publish_wanted";
	}
	
	/**
	 * 求购物品发布提交
	 * @param wantedGoods
	 * @return
	 */
	@RequestMapping(value="/publish_wanted",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> publishWanted(WantedGoods wantedGoods){
		CodeMsg validate = ValidateEntityUtil.validate(wantedGoods);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
			return Result.error(validate);
		}
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		wantedGoods.setPeasant(loginedPeasant);
		if(wantedGoodsService.save(wantedGoods) == null){
			return Result.error(CodeMsg.HOME_PEASANT_PUBLISH_ERROR);
		}
		return Result.success(true);
	}
	
	/**
	 * 编辑求购物品页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit_wanted_goods",method=RequestMethod.GET)
	public String editWantedGoods(@RequestParam(name="id",required=true)Long id,Model model){
		WantedGoods wantedGoods = wantedGoodsService.find(id);
		if(wantedGoods == null){
			model.addAttribute("msg", "求购物品不存在！");
			return "error/runtime_error";
		}
		model.addAttribute("wantedGoods", wantedGoods);
		return "home/peasant/edit_wanted";
	}
	
	/**
	 * 编辑求购信息表单提交
	 * @param wantedGoods
	 * @return
	 */
	@RequestMapping(value="/edit_wanted_goods",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> editWantedGoods(WantedGoods wantedGoods){
		CodeMsg validate = ValidateEntityUtil.validate(wantedGoods);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
			return Result.error(validate);
		}
		if(wantedGoods.getId() == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		WantedGoods existWantedGoods = wantedGoodsService.find(wantedGoods.getId());
		if(existWantedGoods == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		if(existWantedGoods.getPeasant().getId().longValue() != loginedPeasant.getId().longValue()){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		existWantedGoods.setContent(wantedGoods.getContent());
		existWantedGoods.setName(wantedGoods.getName());
		existWantedGoods.setSellPrice(wantedGoods.getSellPrice());
		existWantedGoods.setTradePlace(wantedGoods.getTradePlace());
		if(wantedGoodsService.save(existWantedGoods) == null){
			return Result.error(CodeMsg.HOME_PEASANT_PUBLISH_ERROR);
		}
		
		return Result.success(true);
	}
	
	/**
	 * 删除求购物品
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete_wanted",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> deleteWanted(@RequestParam(name="id",required=true)Long id){
		WantedGoods wantedGoods = wantedGoodsService.find(id);
		if(wantedGoods == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		if(wantedGoods.getPeasant().getId().longValue() != loginedPeasant.getId().longValue()){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		wantedGoodsService.delete(id);
		return Result.success(true);
	}
	
	/**
	 * 举报物品
	 * @param reportGoods
	 * @return
	 */
	@RequestMapping(value="/report_goods",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> reportGoods(ReportGoods reportGoods){
		CodeMsg validate = ValidateEntityUtil.validate(reportGoods);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
			return Result.error(validate);
		}
		if(reportGoods.getGoods() == null || reportGoods.getGoods().getId() == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		ReportGoods find = reportGoodsService.find(reportGoods.getGoods().getId(), loginedPeasant.getId());
		if(find != null){
			return Result.error(CodeMsg.HOME_PEASANT_REPORTED_GOODS);
		}
		reportGoods.setPeasant(loginedPeasant);
		if(reportGoodsService.save(reportGoods) == null){
			return Result.error(CodeMsg.HOME_PEASANT_REPORT_GOODS_ERROR);
		}
		return Result.success(true);
	}
	
	/**
	 * 删除举报信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete_report",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> deleteReport(@RequestParam(name="id",required=true)Long id){
		ReportGoods reportGoods = reportGoodsService.find(id);
		if(reportGoods == null){
			return Result.error(CodeMsg.HOME_PEASANT_REPORTED_NO_EXIST);
		}
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		if(reportGoods.getPeasant().getId().longValue() != loginedPeasant.getId().longValue()){
			return Result.error(CodeMsg.HOME_PEASANT_REPORTED_NO_EXIST);
		}
		reportGoodsService.delete(id);
		return Result.success(true);
	}
	
	/**
	 * 获取个人物品统计信息
	 * @return
	 */
	@RequestMapping(value="/get_stats",method=RequestMethod.POST)
	@ResponseBody
	public Result<Map<String, Integer>> getStats(){
		Map<String, Integer> ret = new HashMap<String, Integer>();
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		List<Goods> findByPeasant = goodsService.findByPeasant(loginedPeasant);
		Integer goodsTotal = findByPeasant.size();//已发布的商品总数
		Integer soldGoodsTotal = 0;
		Integer downGoodsTotal = 0;
		Integer upGoodsTotal = 0;
		for(Goods goods : findByPeasant){
			if(goods.getStatus() == Goods.GOODS_STATUS_SOLD){
				soldGoodsTotal++;
			}
			if(goods.getStatus() == Goods.GOODS_STATUS_DOWN){
				downGoodsTotal++;
			}
			if(goods.getStatus() == Goods.GOODS_STATUS_UP){
				upGoodsTotal++;
			}
		}
		ret.put("goodsTotal", goodsTotal);
		ret.put("soldGoodsTotal", soldGoodsTotal);
		ret.put("downGoodsTotal", downGoodsTotal);
		ret.put("upGoodsTotal", upGoodsTotal);
		return Result.success(ret);
	}
	
	/**
	 * 评论物品
	 * @param comment
	 * @return
	 */
	@RequestMapping(value="/comment",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> comment(Comment comment){
		CodeMsg validate = ValidateEntityUtil.validate(comment);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
			return Result.error(validate);
		}
		if(comment.getGoods() == null || comment.getGoods().getId() == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		Goods find = goodsService.findById(comment.getGoods().getId());
		if(find == null){
			return Result.error(CodeMsg.HOME_PEASANT_GOODS_NO_EXIST);
		}
		comment.setPeasant(loginedPeasant);
		if(commentService.save(comment) == null){
			return Result.error(CodeMsg.HOME_PEASANT_COMMENT_ADD_ERROR);
		}
		return Result.success(true);
	}
	
	/**
	 * 修改学生用户密码
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	@RequestMapping(value="/edit_pwd",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> editPwd(@RequestParam(name="oldPwd",required=true)String oldPwd,
			@RequestParam(name="newPwd",required=true)String newPwd){
		Peasant loginedPeasant = (Peasant)SessionUtil.get(SessionConstant.SESSION_PEASANT_LOGIN_KEY);
		if(!loginedPeasant.getPassword().equals(oldPwd)){
			return Result.error(CodeMsg.HOME_PEASANT_EDITPWD_OLD_ERROR);
		}
		loginedPeasant.setPassword(newPwd);
		if(peasantService.save(loginedPeasant) == null){
			return Result.error(CodeMsg.HOME_PEASANT_EDITINFO_ERROR);
		}
		SessionUtil.set(SessionConstant.SESSION_PEASANT_LOGIN_KEY, loginedPeasant);
		return Result.success(true);
	}
}
