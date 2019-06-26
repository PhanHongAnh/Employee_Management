package com.hrsmanager.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrsmanager.dao.EmployeeDAO;
import com.hrsmanager.model.EmployeeInfo;

@Service
public class MyDBAuthenticationService /*implements UserDetailsService*/ {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	/*@Override
	public UserDetails loadUserByUsername(Integer employee_id) throws UsernameNotFoundException{
		EmployeeInfo emp = employeeDAO.findEmployeeInfo(employee_id);
		if (emp == null) {
			throw new UsernameNotFoundException("Employee"+employee_id+"was not found");
		}
		UserDetails empDetails = (UserDetails) new User(emp.getEmployeeID(),
				emp.getPassword(),grantList);
		return empDetails;
	}*/
}
