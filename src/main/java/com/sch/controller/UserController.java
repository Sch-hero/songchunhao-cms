package com.sch.controller;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sch.comon.ConstClass;
import com.sch.entity.User;
import com.sch.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("register")//只能接受get的请求
	public String register() {
		return "user/register";
	}
	
	@RequestMapping("index")
	public String index() {
		return "user/index";
	}
	
	/**
	 * 判断用户名是否被占用
	 * @param username
	 * @return
	 */
	@RequestMapping("checkExist")
	@ResponseBody
	public boolean checkExist(String username) {
		
		return !userService.checkUserExist(username);
	}
	
	
	
	@PostMapping("register")//只接受post的请求
	public String reqister(HttpServletRequest request,@Validated User user,BindingResult err) {
		if (err.hasErrors()) {
			return "user/register";
		}
		
		int result = userService.register(user);
		if (result>0) {
			return "redirect:login";
		}else {
			request.setAttribute("err", "系统错误，请稍后重试");
			return "user/register";
		}
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute(ConstClass.SESSION_USER_KEY);
		return "user/login";
	}
	
	@PostMapping("login")//只接受Post的请求
	public String login(HttpServletRequest request,@Validated User user,BindingResult errorResuit) {
		if (errorResuit.hasErrors()) {
			
			return "login";
		}
		
		//登录
		User loginUser = userService.login(user);
		if (loginUser==null) {
			request.setAttribute("erroMsg", "用户密码错误");
			return "user/login";
		}else {
			request.getSession().setAttribute(ConstClass.SESSION_USER_KEY, loginUser);
			if (loginUser.getRole()==ConstClass.User_ROLE_ADMIN) {
				return "redirect:home";
			}else if (loginUser.getRole()==ConstClass.User_ROLE_ADMIN) {
				return "redirect:../admin/index";
			}else {
				//其他情况
				return "user/login";
			}
		}
	}
}
