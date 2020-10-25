package com.jxau.grain.controller.home;


import com.jxau.grain.bean.CodeMsg;
import com.jxau.grain.bean.PageBean;
import com.jxau.grain.bean.Result;
import com.jxau.grain.constant.SessionConstant;
import com.jxau.grain.entity.common.Goods;
import com.jxau.grain.entity.common.News;
import com.jxau.grain.entity.common.Peasant;
import com.jxau.grain.service.common.GoodsCategoryService;
import com.jxau.grain.service.common.GoodsService;
import com.jxau.grain.service.common.NewsService;
import com.jxau.grain.service.common.PeasantService;
import com.jxau.grain.util.SessionUtil;
import com.jxau.grain.util.ValidateEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 前台首页控制器
 * @author Administrator
 *
 */
@RequestMapping("/home/index")
@Controller
public class IndexController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	@Autowired
	private PeasantService peasantService;
	@Autowired
	private NewsService newsService;
	/**
	 * 前台首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Model model, PageBean<Goods> pageBean, Goods goods){
		pageBean.setPageSize(8);
		goods.setStatus(Goods.GOODS_STATUS_UP);
		model.addAttribute("pageBean", goodsService.findlist(pageBean, goods));
		model.addAttribute("name",goods.getName());
		model.addAttribute("newsList",newsService.findList(3));
		return "home/index/index";
	}
	
	/**
	 * 新闻详情页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/news_detail")
	public String index(Model model,@RequestParam(name="id",required=true)Long id){
		News news = newsService.find(id);
		model.addAttribute("news",news);
		news.setViewNumber(news.getViewNumber()+1);
		newsService.save(news);
		return "home/index/news_detail";
	}
	
	/**
	 * 用户登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method= RequestMethod.GET)
	public String login(Model model){
		return "home/index/login";
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(){
		SessionUtil.set(SessionConstant.SESSION_PEASANT_LOGIN_KEY, null);
		return "redirect:login";
	}
	
	/**
	 * 检查农民编号是否存在
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/check_sn",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> checkSn(@RequestParam(name="pn",required=true)String pn){
		Peasant peasant = peasantService.findByPn(pn);
		return Result.success(peasant == null);
	}
	
	/**
	 * 用户注册表单提交
	 * @param peasant
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> register(Peasant peasant){
		CodeMsg validate = ValidateEntityUtil.validate(peasant);
		if(validate.getCode() != CodeMsg.SUCCESS.getCode()){
			return Result.error(validate);
		}

		//基本验证通过
		if(peasantService.findByPn(peasant.getPn()) != null){
		return Result.error(CodeMsg.HOME_PEASANT_REGISTER_SN_EXIST);
		}
		peasant = peasantService.save(peasant);
		if(peasant == null){
			return Result.error(CodeMsg.HOME_PEASANT_REGISTER_ERROR);
		}

		//表示注册成功，此时将用户信息放入session
		SessionUtil.set(SessionConstant.SESSION_PEASANT_LOGIN_KEY, peasant);
		return Result.success(true);

	}
	
	/**
	 * 用户登录表单提交
	 * @param pn
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Result<Boolean> login(@RequestParam(name="pn",required=true)String pn,
			@RequestParam(name="password",required=true)String password){
		Peasant peasant = peasantService.findByPn(pn);
		if(peasant == null){
			return Result.error(CodeMsg.HOME_PEASANT_REGISTER_SN_EXIST);
		}
		peasant = peasantService.save(peasant);
		if(peasant == null){
			return Result.error(CodeMsg.HOME_PEASANT_SN_NO_EXIST);
		}
		//表示用户Id存在，验证密码是否正确
		if(!peasant.getPassword().equals(password)){
			return Result.error(CodeMsg.HOME_PEASANT_PASSWORD_ERROR);
		}
		//验证用户状态是否被冻结
		if(peasant.getStatus() != Peasant.PEASANT_STATUS_ENABLE){
			return Result.error(CodeMsg.HOME_PEASANT_UNABLE);
		}
		//表示一切都符合，此时将用户信息放入session
		SessionUtil.set(SessionConstant.SESSION_PEASANT_LOGIN_KEY, peasant);
		return Result.success(true);
	}
}
