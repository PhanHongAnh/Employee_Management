package com.hrsmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Employee {
	@RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("employees");
	}
	
	@RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value = {"/editprofile"}, method = RequestMethod.GET)
	public ModelAndView edit() {
		return new ModelAndView("editprofile");
	}
	
	@RequestMapping(value = {"/newemployee"}, method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("newemployee");
	}
	
	@RequestMapping(value = {"/password"}, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView password() {
		return new ModelAndView("password");
	}

}
