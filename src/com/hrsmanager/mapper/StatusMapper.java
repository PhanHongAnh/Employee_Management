package com.hrsmanager.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.hrsmanager.model.Status;

public class StatusMapper implements RowMapper<Status>{

	@Override
	public Status mapRow(ResultSet rs, int rowNum) throws SQLException{
		Integer status_id = rs.getInt("status_id");
		String status_name = rs.getString("status_name");
		Timestamp created_at = rs.getTimestamp("created_at");
		Timestamp updated_at = rs.getTimestamp("updated_at");
		
		Status status = new Status(status_id, status_name);
		status.setCreated_at(created_at);
		status.setUpdated_at(updated_at);
	
		return status;
	}
}
