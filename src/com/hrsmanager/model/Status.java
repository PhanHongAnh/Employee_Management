package com.hrsmanager.model;

import java.sql.Timestamp;

public class Status {

	private Integer statusId;
	private String statusName;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public Status(Integer status_id, String status_name) {
		this.statusId = status_id;
		this.statusName = status_name;
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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
