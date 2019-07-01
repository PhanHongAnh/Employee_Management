package com.hrsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrsmanager.authentication.EmployeeService;
import com.hrsmanager.model.EmployeeInfo;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("employees");
	}
	
	@RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
	public ModelAndView show() {
		EmployeeInfo emp = employeeService.findEmployeeInfo(20002000);
		return new ModelAndView("profile", "emp", emp);
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
