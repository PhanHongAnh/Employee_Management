package com.hrsmanager.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.hrsmanager.model.DepartmentInfo;

public class DepartmentMapper implements RowMapper<DepartmentInfo>{

	@Override
	public DepartmentInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
		Integer department_id = rs.getInt("department_id");
		String department_name = rs.getString("department_name");
		String department_phone = rs.getString("department_phone");
		String department_address = rs.getString("department_address");
		Timestamp created_at = rs.getTimestamp("created_at");
		Timestamp updated_at = rs.getTimestamp("updated_at");
		Boolean active = rs.getBoolean("active");
		
		DepartmentInfo depart = new DepartmentInfo(department_id, department_name);
		depart.setDepartment_address(department_address);
		depart.setDepartment_phone(department_phone);
		depart.setCreated_at(created_at);
		depart.setUpdated_at(updated_at);
		depart.setActive(active);
		
		return depart;
	}
}
