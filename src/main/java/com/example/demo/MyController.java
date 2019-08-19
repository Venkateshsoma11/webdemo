package com.example.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/xyz")
	@ResponseBody
	public String abc()
	{
		return ("<h1>--------------Welcome to first web response----------</h1>"
				+ "<hr><h3>hi hi hi hi hi </h3>");
	}
	
	@RequestMapping("/greet")
		public String demo()
	{
		return "welcome";
	}
	@RequestMapping({"/","/login"})
	public String login()
	{
		return "login";
		
	}
	@RequestMapping("/welcome")
	@ResponseBody
	public String loginProcess(String uname,String upwd)
	{	
		System.out.println("Username: "+ uname);
		return "<h1>HIHIHAHAHA</h1/>";
	}
	@RequestMapping("/welcome2")
	
	public String loginProcess2(HttpServletRequest req)
	{	
		String user = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		HttpSession session = req.getSession();
		session.setAttribute("username", user);
		return "welcome";
	}
	
	@RequestMapping("/welcome3")
	public ModelAndView loginProcess2(User user)
	{	
		System.out.println("Username: "+ user.getUname());
		System.out.println("Password: "+ user.getPwd());
		ModelAndView mv=new ModelAndView();
		mv.addObject(user);
		if(user.getUname().equals(user.getPwd()))
			mv.setViewName("welcome");
		else 
			mv.setViewName("invalid");
		return mv;
	}
	

}
