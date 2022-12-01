package com.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project1.dao.ProjectDao;

@Controller
public class ProjectController {
	@Autowired
	private ProjectDao dao;
	String forgotPasswordEmail =null;
	@GetMapping("/signu")
	public String signup() {
		return "signupform";
	}
	@PostMapping("/submitsignupform")
	public String submitsignupform(@RequestParam("username") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,Model model) {
		System.out.println(name+" "+email+" "+password);
		boolean result=dao.signup(email, name, password);
		System.out.println(result);
		if(result==false) {
			model.addAttribute("message","Data Already Exists....!!!");
			return "signupform";
		}else {
			return "signupcompleted";
		}

	}
	
	@GetMapping("/login")
	public String login() {
		return "loginform";
	}
	@PostMapping("/submitloginform")
	public String submitloginform(@RequestParam ("email") String email,
			@RequestParam ("pswd") String password,Model model) {
		System.out.println(email+" "+password);
		boolean result=dao.login(email, password);
		if(result==false) {
			model.addAttribute("message","Invalid Credentials....!!");
			return "loginform";
		}else {
			return "homepage";
		}
	}
	
	@GetMapping("/forgotpassword")
	public String forgotpassword() {
		return "forgotpasswordform";
	}
	@PostMapping("/submitforgotpassword")
	public String submitforgotpassword(@RequestParam ("email") String email,
			@RequestParam ("username") String name,Model model) {
		forgotPasswordEmail = email;
		boolean result=dao.verifyuser(email, name);
		if(result==false) {
			model.addAttribute("message","User not found...!!");
			return "forgotpasswordform";
		}else {
			model.addAttribute("status","true");
			return "forgotpasswordform";
		}
	}
	@PostMapping("/submitnewpassword")
	public String changepassword(@RequestParam("password") String password,Model model) {
		boolean result=dao.updatePassword(forgotPasswordEmail,password);
		if(result==false) {
			model.addAttribute("message","something went wrong");
			return "forgotpasswordform";
		}else {
			model.addAttribute("message","Password Updated succesfully");
			return "loginform";
		}
	}
}
