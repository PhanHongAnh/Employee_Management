package com.hrsmanager.model;

import java.sql.Timestamp;

public class PositionInfo {

	private Integer position_id;
	private String position_name;
	private Timestamp created_at;
	private Timestamp updated_at;
	private boolean active;
	
	public PositionInfo(Integer position_id, String position_name) {
		this.position_id = position_id;
		this.position_name = position_name;
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
		this.active = true;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
