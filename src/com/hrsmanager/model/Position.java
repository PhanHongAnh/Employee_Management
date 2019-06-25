package com.hrsmanager.model;

import java.sql.Timestamp;

public class Position {
	private Integer position_id;
	private String position_name;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Timestamp deleted_at;
	
	
	public Integer getPositionID() {
		return position_id;
	}
	
	public String getPositionName() {
		return position_name;
	}
	
	public Timestamp getCreatedAt() {
		return created_at;
	}
	
	public Timestamp getUpdatedAt() {
		return updated_at;
	}
	
	public Timestamp getDeletedAt() {
		return deleted_at;
	}
}
