package com.sch.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.sch.comon.ConstClass;
import com.sch.entity.User;

/**
 * 
 * @宋春浩
 *
 * 2019年10月17日
 */
public class AuthIntercepter implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
			User loginUsre = (User) request.getSession().getAttribute(ConstClass.SESSION_USER_KEY);
		
			if (loginUsre==null) {
				request.getRequestDispatcher("user/login").forward(request, response);
				return false;
			}	
				
		return true;
	}
	
}
