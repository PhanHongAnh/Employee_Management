package com.hrsmanager.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.hrsmanager.model.Roles;

public class RoleMapper implements RowMapper<Roles>{

	@Override
	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException{
		Integer role_id = rs.getInt("role_id");
		String role_name = rs.getString("role_name");
		Timestamp created_at = rs.getTimestamp("created_at");
		Timestamp updated_at = rs.getTimestamp("updated_at");
		Boolean active = rs.getBoolean("active");
		
		Roles role = new Roles(role_id, role_name);
		role.setCreated_at(created_at);
		role.setUpdated_at(updated_at);
		role.setActive(active);
	
		return role;
	}
}
