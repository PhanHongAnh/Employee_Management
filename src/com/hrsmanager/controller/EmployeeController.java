package com.hrsmanager.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

	@RequestMapping(value = { "/employees/{pageId}" }, method = RequestMethod.GET)
	public String listEmployee(Model model, @PathVariable int pageId, HttpServletRequest request) {
		int totalView = 6;
		request.setAttribute("page_pre", pageId);
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		EmployeeInfo emp_login = (EmployeeInfo) session.getAttribute("emp_login");
		if (emp_login == null) {
			return "redirect:/login";
		} else {
			if (role.equals("ADMIN")) {
				
				if(session.getAttribute("total_view")!=null) { 
					totalView = Integer.valueOf((String)session.getAttribute("total_view")); 
					}
				 
				List<EmployeeInfo> list = employeeService.listEmployee();
				List<DepartmentInfo> listDepartments = departmentDAO.listDeapartments();
				List<PositionInfo> listPositions = positionDAO.listPositions();
				model.addAttribute("listDepartments", listDepartments);
				model.addAttribute("listPositions", listPositions);
				model.addAttribute("list", list);
				model.addAttribute("total", list.size());

				// list page
				int totalPage = 0;
				if ((list.size() % totalView) > 0) {
					totalPage = list.size() / totalView + 1;
					session.setAttribute("totalPage", totalPage);
				} else {
					totalPage = list.size() / totalView;
					session.setAttribute("totalPage", totalPage);
				}
				if (pageId == 1) {
					List<EmployeeInfo> listPage = employeeService.listPage(pageId - 1, totalView);
					model.addAttribute("listPage", listPage);
				} else {
					List<EmployeeInfo> listPage = employeeService.listPage((pageId - 1) * totalView, totalView);
					model.addAttribute("listPage", listPage);
				}
				return "employees";
			} else {
				return "redirect:/employee/" + emp_login.getEmployeeId().toString();
			}
		}
	}

	@RequestMapping(value = { "/type" }, method = RequestMethod.POST)
	public String listView(Model model, HttpServletRequest request) {
		String type = request.getParameter("type_view");
		HttpSession session = request.getSession();
		if ("card".equals(type)) {
			session.setAttribute("type_view", "card");
			session.setAttribute("total_view", "6");
			return "redirect:/employees/1";
		} else {
			session.setAttribute("type_view", "list");
			session.setAttribute("total_view", "5");
			return "redirect:/employees/1";
		}

	}

	@RequestMapping(value = { "/employee/{id}" }, method = RequestMethod.GET)
	public String profile(@PathVariable int id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		EmployeeInfo emp_login = (EmployeeInfo) session.getAttribute("emp_login");
		if (emp_login == null) {
			return "redirect:/login";
		} else if (role.equals("ADMIN")) {
			EmployeeInfo emp = employeeService.findByID(id);
			String position_name = positionDAO.findPositionByID(emp.getPositionId()).getPositionName();
			DepartmentInfo department = (DepartmentInfo) departmentDAO.findDepartmentByID(emp.getDepartmentId());
			model.addAttribute("position", position_name);
			model.addAttribute("department", department);
			model.addAttribute("emp", emp);
			return "profile";
		} else {
			String position_name = positionDAO.findPositionByID(emp_login.getPositionId()).getPositionName();
			DepartmentInfo department = (DepartmentInfo) departmentDAO.findDepartmentByID(emp_login.getDepartmentId());
			model.addAttribute("position", position_name);
			model.addAttribute("department", department);
			model.addAttribute("emp", emp_login);
			return "profile";
		}
	}

	@RequestMapping(value = { "/employee/{id}/edit" }, method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		EmployeeInfo emp_login = (EmployeeInfo) session.getAttribute("emp_login");
		if (emp_login == null) {
			return "redirect:/login";
		} else {
			if (role.equals("ADMIN")) {
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
				return "editprofile";
			} else {
				return "redirect:/employee/" + emp_login.getEmployeeId().toString();
			}
		}
	}

	@RequestMapping(value = { "/employee/{id}/update" }, method = RequestMethod.POST)
	public String update(@PathVariable int id, HttpSession session, @RequestParam(value = "name") String name,
			@RequestParam(value = "gender") String gender, @RequestParam(value = "dob") String dob,
			@RequestParam(value = "address") String address, @RequestParam(value = "phone") String phone,
			@RequestParam(value = "email") String email, @RequestParam(value = "std") String std,
			@RequestParam(value = "status_id") String status, @RequestParam(value = "role_id") String role,
			@RequestParam(value = "department_id") String department,
			@RequestParam(value = "position_id") String position, @RequestParam CommonsMultipartFile avt)
			throws Exception {

		Date birthday = Date.valueOf(dob);
		Date started_day = Date.valueOf(std);
		Integer status_id = Integer.valueOf(status);
		Integer role_id = Integer.valueOf(role);
		Integer department_id = Integer.valueOf(department);
		Integer position_id = Integer.valueOf(position);
		Timestamp updated_at = new Timestamp(System.currentTimeMillis());

		boolean hasError = false;
		String error = null;
		String avatar = null;
		String path = "C:/Users/admin/project-workspace/Employee_Management/WebContent/resources/img";

		if (avt.isEmpty()) {
			avatar = employeeService.findByID(id).getAvatar();
		} else {
			avatar = avt.getOriginalFilename();
			if (avt.getContentType().contains("image") && avt.getSize() <= 3 * 1024 * 1024) {
				// upload file
				byte[] bytes = avt.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + File.separator + avatar)));
				stream.write(bytes);
				stream.flush();
				stream.close();
			} else {
				hasError = true;
				error = "Avatar must be image file (size <= 3Mb)";
			}
		}

		if (employeeService.checkEmail(email)) {
			hasError = true;
			error = "Email is already in use. Please enter another email.";
		}
		
		if (hasError) {
			session.setAttribute("error", error);
			return "redirect:/employee/" + id + "/edit";
		} else {
			EmployeeInfo emp = employeeService.updateEmployee(name, gender, birthday, address, phone, email,
					started_day, status_id, role_id, updated_at, department_id, position_id, avatar, id);
			if (emp != null) {
				return "redirect:/employee/" + id;
			} else {
				return "redirect:/employee/" + id + "/edit";
			}
		}
	}

	/*-----------------create Employee----------------------------------------*/
	@RequestMapping(value = { "/employee/new" }, method = RequestMethod.GET)
	public String show(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");
		EmployeeInfo emp_login = (EmployeeInfo) session.getAttribute("emp_login");
		if (emp_login == null) {
			return "redirect:/login";
		} else {
			if (role.equals("ADMIN")) {
				List<Status> listStatuses = statusDAO.listStatus();
				List<Roles> listRoles = roleDAO.listRoles();
				List<DepartmentInfo> listDepartments = departmentDAO.listDeapartments();
				List<PositionInfo> listPositions = positionDAO.listPositions();
				model.addAttribute("listStatuses", listStatuses);
				model.addAttribute("listRoles", listRoles);
				model.addAttribute("listDepartments", listDepartments);
				model.addAttribute("listPositions", listPositions);
				return "newemployee";
			} else {
				return "redirect:/employee/" + emp_login.getEmployeeId().toString();
			}
		}
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public String create(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam CommonsMultipartFile avt) throws Exception {

		boolean hasError = false;
		String error = null;
		String avatar = null;
		String path = "C:/Users/admin/project-workspace/Employee_Management/WebContent/resources/img";

		if (StringUtils.isNumeric(request.getParameter("id")) && request.getParameter("id").length() <= 11) {
			Integer employee_id = Integer.valueOf((String) request.getParameter("id"));
			String employee_name = request.getParameter("name");
			String gender = request.getParameter("gender");
			Date birthday = java.sql.Date.valueOf(request.getParameter("dob"));
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String password = BCrypt.hashpw(String.valueOf(employee_id), BCrypt.gensalt(12));
			Date started_day = java.sql.Date.valueOf(request.getParameter("std"));
			Integer role_id = Integer.valueOf((String) request.getParameter("role_id"));
			Integer status_id = Integer.valueOf((String) request.getParameter("status_id"));
			Integer department_id = Integer.valueOf((String) request.getParameter("department_id"));
			Integer position_id = Integer.valueOf((String) request.getParameter("position_id"));

			if (!avt.isEmpty()) {
				avatar = avt.getOriginalFilename();
				if (avt.getContentType().contains("image") && avt.getSize() <= 3 * 1024 * 1024) {
					// upload file
					byte[] bytes = avt.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(path + File.separator + avatar)));
					stream.write(bytes);
					stream.flush();
					stream.close();
				} else {
					hasError = true;
					error = "Avatar must be image file (size <= 3Mb)";
				}
			}
			
			if (!employeeService.checkEmail(email)) {
				EmployeeInfo emp = new EmployeeInfo(employee_id, employee_name, gender, birthday, phone, email, password, address, avatar);
				int k = employeeService.newEmployeeInfo(emp, department_id, position_id, role_id, status_id, started_day);
				if (k<=0) {
					hasError = true;
					error = "Cannot create new user";
				}
			} else {
				hasError = true;
				error = "Email is already in use. Please enter another email.";
			}
			
		} else {
			hasError = true;
			error = "Invalid Employee ID. Please enter employee's information again.";
		}

		if (hasError) {
			session.setAttribute("error", error);
			return "redirect:/employee/new";
		} else {
			return "redirect:/employees/1";
		}
	}

	@RequestMapping(value = { "/employee/{id}/change_password" }, method = { RequestMethod.GET })
	public ModelAndView password(@PathVariable int id, HttpServletRequest request) {
		EmployeeInfo emp = employeeService.findByID(id);
		return new ModelAndView("password", "emp", emp);
	}

	@RequestMapping(value = { "/employee/{id}/update_password" }, method = { RequestMethod.POST })
	public String update_password(@PathVariable int id, HttpServletRequest request,
			@RequestParam(value = "password1") String password1, @RequestParam(value = "password2") String password2) {

		String error = null;
		boolean hasError = false;
		EmployeeInfo emp = null;
		HttpSession session = request.getSession();

		if (!password1.isEmpty() && !password2.isEmpty()) {
			if (password1.length() >= 8 && password1.matches(".*\\d.*") && password1.equals(password2)) {
				String password = BCrypt.hashpw(String.valueOf(password1), BCrypt.gensalt(12));
				emp = employeeService.updatePassword(id, password);
				if (emp == null) {
					hasError = true;
					error = "Cannot update password";
				}
			}
		}

		if (hasError) {
			session.setAttribute("error", error);
			return "redirect:/employee/" + id + "/change_password";
		} else {
			return "redirect:/login";
		}
	}
}
