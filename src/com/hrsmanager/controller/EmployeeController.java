package com.hrsmanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.hrsmanager.authentication.EmployeeService;
import com.hrsmanager.dao.PositionDAO;
import com.hrsmanager.model.EmployeeInfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	private PositionDAO positionDAO;
	
	@RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("employees");
	}
	
	@RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
	public String profile(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		EmployeeInfo emp = (EmployeeInfo)session.getAttribute("emp");
		String position_name = positionDAO.findPositionInfo(emp.getPosition_id()).getPosition_name();
		model.addAttribute("position", position_name);
		model.addAttribute("emp", emp);
		return "profile";
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
