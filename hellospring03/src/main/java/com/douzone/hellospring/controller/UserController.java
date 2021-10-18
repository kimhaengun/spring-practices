package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author user
 * @RequestMapping 클래스(타입) + 핸들러(메소드)
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("email")String email) {
		/**
		 * 만일 email 이라는 이림의 파라미터가 없는 경우
		 * 400에러 나옴
		 */
		System.out.println("email");
		return "UserController.update()";
	}

	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="email",required = true, defaultValue = "")String email,
			@RequestParam(value = "age",required = true, defaultValue = "0") int age) {
		
		//defaultValue = 받아오는 값이 없을 경우 값 설정
		
		/**
		 * 만일 email 이라는 이림의 파라미터가 없는 경우
		 * 400에러 나옴
		 */
		System.out.println("------"+email+"------------");
		System.out.println("------"+age+"------------");
		return "UserController.update()";
	}
}
