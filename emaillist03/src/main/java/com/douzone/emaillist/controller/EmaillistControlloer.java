package com.douzone.emaillist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.emaillist.repository.EmaillistRepository;

@Controller
public class EmaillistControlloer {
	
	@Autowired
	private EmaillistRepository emaillstRepository;
	
	@ResponseBody
	@RequestMapping("")
	public String index() {
		System.out.println(emaillstRepository);
		return "Emaillist Index";
	}
}
