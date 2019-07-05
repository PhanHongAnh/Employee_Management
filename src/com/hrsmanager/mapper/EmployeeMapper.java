package com.hrsmanager.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.hrsmanager.model.EmployeeInfo;

public class EmployeeMapper implements RowMapper<EmployeeInfo>{

	@Override
	public EmployeeInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
		Integer employee_id = rs.getInt("employee_id");
		String employee_name = rs.getString("employee_name");
		String gender = rs.getString("gender");
		Date birthday = rs.getDate("birthday");
		String address = rs.getString("address");
		String phone = rs.getString("phone");
		String email = rs.getString("email");
		String password = rs.getString("password");
		Date started_day = rs.getDate("started_day");
		Integer role_id = rs.getInt("role_id");
		Integer status_id = rs.getInt("status_id");
		Integer department_id = rs.getInt("department_id");
		Integer position_id = rs.getInt("position_id");
		Timestamp created_at = rs.getTimestamp("created_at");
		Timestamp updated_at = rs.getTimestamp("updated_at");
		EmployeeInfo emp = new EmployeeInfo(employee_id, employee_name, gender, birthday, phone, email, password, address);
		
		emp.setStarted_day(started_day);
		emp.setRole_id(role_id);
		emp.setStatus_id(status_id);
		emp.setDepartment_id(department_id);
		emp.setPosition_id(position_id);
		emp.setCreated_at(created_at);
		emp.setUpdated_at(updated_at);
		return emp;
	}
}
