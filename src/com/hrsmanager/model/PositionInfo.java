package com.hrsmanager.model;

import java.sql.Timestamp;

public class PositionInfo {

	private Integer positionId;
	private String positionName;
	private Timestamp created_at;
	private Timestamp updated_at;
	private boolean active;
	
	public PositionInfo(Integer position_id, String position_name) {
		this.positionId = position_id;
		this.positionName = position_name;
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
		this.active = true;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
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
