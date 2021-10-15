package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String Hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String Hello2(@RequestParam("n") String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView Hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name",name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}
	
	@RequestMapping("/hello4")
	public String Hello4(String name, Model model) {
		
		model.addAttribute("name",name);
		return "/WEB-INF/views/hello3.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello5")
	public String Hello5() {
		
		return "<h1>ResponseBody test<h1>";
	}
	
	@RequestMapping("/hello6")
	public String Hello6() {
		System.out.println("hello6 call");
		return "redirect:/hello";
	}
}
