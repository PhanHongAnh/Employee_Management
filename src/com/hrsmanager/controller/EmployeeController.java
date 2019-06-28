package com.hrsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrsmanager.authentication.EmployeeService;
import com.hrsmanager.model.EmployeeInfo;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = {"/employeeInfo"}, method = RequestMethod.GET)
	public String viewEmployee(Model model) {
		EmployeeInfo emp = employeeService.loadEmployeeByID(1);
		model.addAttribute("emp",emp);
		System.out.println(emp.getEmployee_name());
		return "employeeInfo";
	}
}
