package com.hrsmanager.model;

import java.sql.Timestamp;

public class Status {

	private Integer status_id;
	private String status;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public Status(Integer status_id, String status) {
		this.status_id = status_id;
		this.status = status;
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
	}

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
