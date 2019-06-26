package com.hrsmanager.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrsmanager.dao.EmployeeDAO;
import com.hrsmanager.model.EmployeeInfo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public EmployeeInfo loadEmployeeByID(Integer employee_id){
		EmployeeInfo emp = employeeDAO.findEmployeeInfo(employee_id);
		
		if (emp == null) {
			throw new UsernameNotFoundException("Employee"+employee_id+"was not found");
		}
		return emp;
	}
}
