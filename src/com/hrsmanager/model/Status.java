package com.hrsmanager.model;

import java.sql.Timestamp;

public class Status {

	private Integer status_id;
	private String status_name;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Boolean active;
	
	public Status(Integer status_id, String status_name) {
		this.status_id = status_id;
		this.status_name = status_name;
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
		this.active = true;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
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
	
	
}
