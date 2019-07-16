package com.hrsmanager.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.hrsmanager.authentication.EmployeeService;
import com.hrsmanager.model.DepartmentInfo;
import com.hrsmanager.dao.DepartmentDAO;
import com.hrsmanager.dao.PositionDAO;
import com.hrsmanager.dao.RoleDAO;
import com.hrsmanager.dao.StatusDAO;
import com.hrsmanager.model.EmployeeInfo;
import com.hrsmanager.model.PositionInfo;
import com.hrsmanager.model.Roles;
import com.hrsmanager.model.Status;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	private PositionDAO positionDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	private StatusDAO statusDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@RequestMapping(value = {"/employees"}, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("employees");
	}
	
	@RequestMapping(value = {"/employee/{id}"}, method = RequestMethod.GET)
	public String profile(@PathVariable int id, Model model) {
		EmployeeInfo emp = employeeService.findByID(id);
		String position_name = positionDAO.findPositionInfo(emp.getPosition_id()).getPosition_name();
		DepartmentInfo department = (DepartmentInfo) departmentDAO.findDepartmentInfo(emp.getDepartment_id());
		model.addAttribute("position", position_name);
		model.addAttribute("department", department);
		model.addAttribute("emp", emp);
		return "profile";
	}
	
	@RequestMapping(value = {"/employee/{id}/edit"}, method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id, Model model) {
		EmployeeInfo emp = employeeService.findByID(id);
		List<Status> listStatuses = statusDAO.listStatus();
		List<Roles> listRoles = roleDAO.listRoles();
		List<DepartmentInfo> listDepartments = departmentDAO.listDeapartments();
		List<PositionInfo> listPositions = positionDAO.listPositions();
		
		model.addAttribute("emp", emp);
		model.addAttribute("listStatuses", listStatuses);
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("listDepartments", listDepartments);
		model.addAttribute("listPositions", listPositions);
		return new ModelAndView("editprofile");
	}
	
	@RequestMapping(value = {"/employee/{id}/update"}, method = RequestMethod.POST)
	public String update(@PathVariable int id,
			@RequestParam(value ="name") String name,
			@RequestParam(value ="gender") String gender, 
			@RequestParam(value ="bod") String bod, 
			@RequestParam(value ="address") String address, 
			@RequestParam(value ="phone") String phone, 
			@RequestParam(value ="email") String email, 
			@RequestParam(value ="std") String std,
			@RequestParam(value ="status") String status,
			@RequestParam(value ="role") String role,
			@RequestParam(value ="department") String department,
			@RequestParam(value ="position") String position
			) {
		
		Date birthday = Date.valueOf(bod);
		Date started_day = Date.valueOf(std);
		Integer status_id = Integer.valueOf(status);
		Integer role_id = Integer.valueOf(role);
		Integer department_id = Integer.valueOf(department);
		Integer position_id = Integer.valueOf(position);
		Timestamp updated_at = new Timestamp(System.currentTimeMillis());
		
		EmployeeInfo emp = employeeService.updateEmployee(name, gender, 
				birthday, address, phone, email, started_day, status_id, role_id,
				updated_at, department_id, position_id, id);
		
		if (emp != null) {
			return "redirect:/employee/" + id;
		}
		else return "redirect:/employee/" + id + "/edit";
	}
	
	@RequestMapping(value = {"/employee/{id}"}, method = RequestMethod.DELETE)
	public ModelAndView delete() {
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value = {"/employee/new"}, method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("newemployee");
	}
	
	@RequestMapping(value = {"/employee/{id}/change_password"}, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView password() {
		return new ModelAndView("password");
	}
}
