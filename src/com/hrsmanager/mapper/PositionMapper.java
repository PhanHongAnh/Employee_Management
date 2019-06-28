package com.hrsmanager.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.hrsmanager.model.PositionInfo;

public class PositionMapper implements RowMapper<PositionInfo>{

	@Override
	public PositionInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
		Integer position_id = rs.getInt("position_id");
		String position_name = rs.getString("position_name");
		Timestamp created_at = rs.getTimestamp("created_at");
		Timestamp updated_at = rs.getTimestamp("updated_at");
		Boolean active = rs.getBoolean("active");
		
		PositionInfo position = new PositionInfo(position_id, position_name);
		position.setCreated_at(created_at);
		position.setUpdated_at(updated_at);
		position.setActive(active);
		
		return position;
	}
}
