package com.hrsmanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrsmanager.authentication.EmployeeService;
import com.hrsmanager.model.EmployeeInfo;

@Controller
public class LoginController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String show_login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = {"/login_check"}, method = RequestMethod.POST)
	public String check_login(Model model, HttpServletRequest request,
			@RequestParam(value ="email") String email, @RequestParam(value ="password") String password) {
		EmployeeInfo emp = (EmployeeInfo) employeeService.findByEmailPass(email,password);
		model.addAttribute("emp",emp);
		HttpSession session = request.getSession();
		if (emp != null) {
			session.setAttribute("emp", emp);
			String id = emp.getEmployee_id().toString();
			return "redirect:/employee/" + id;
		}
		else return "login";
	}
	
}
