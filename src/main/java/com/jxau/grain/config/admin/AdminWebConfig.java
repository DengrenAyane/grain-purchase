package com.jxau.grain.config.admin;

import com.jxau.grain.constant.RuntimeConstant;
import com.jxau.grain.interceptor.admin.AdminLoginInterceptor;
import com.jxau.grain.interceptor.admin.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 用来配置拦截器的配置类
 */

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
	
	@Autowired
	private AdminLoginInterceptor loginInterceptor;
	
	@Autowired
	private AuthorityInterceptor authorityInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		//拦截所有用户登录的接口，除了RuntimeConstant里定义的路径
	    registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(RuntimeConstant.loginExcludePathPatterns);

		//拦截所有带权限的接口，除了RuntimeConstant里定义的路径，登录的其实也包括，但是更多要放的，这是全局权限设定
	    registry.addInterceptor(authorityInterceptor).addPathPatterns("/**").excludePathPatterns(RuntimeConstant.authorityExcludePathPatterns);

	}

}
