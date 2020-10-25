package com.jxau.grain.interceptor.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxau.grain.config.SiteConfig;
import com.jxau.grain.entity.common.SiteSetting;
import com.jxau.grain.service.common.FriendLinkService;
import com.jxau.grain.service.common.GoodsCategoryService;
import com.jxau.grain.service.common.SiteSettingService;
import com.jxau.grain.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;



/**
 * 前台全局拦截器
 * @author Administrator
 *
 */
@Component
public class HomeGlobalInterceptor implements HandlerInterceptor{

	@Autowired
	private GoodsCategoryService goodsCategoryService;
	@Autowired
	private SiteConfig siteConfig;
	@Autowired
	private FriendLinkService friendLinkService;
	@Autowired
	private SiteSettingService siteSettingService;

	@Override
	public boolean  preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		
		if(!StringUtil.isAjax(request)){
			//若不是ajax请求，则将菜单信息放入页面模板变量
			request.setAttribute("goodsCategorys", goodsCategoryService.findAll());
			request.setAttribute("friendLinkList", friendLinkService.findList(8));
			SiteSetting siteSetting = siteSettingService.find();
			if(siteSetting != null){
				request.setAttribute("siteName", siteSetting.getSiteName());
				request.setAttribute("siteSetting", siteSetting);
			}
		}
		return true;
	}
}
