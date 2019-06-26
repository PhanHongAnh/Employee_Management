package com.hrsmanager.model;

import java.sql.Timestamp;

public class Role {

	private Integer role_id;
	private String role;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public Role(Integer role_id, String role) {
		this.role_id = role_id;
		this.role = role;
		new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
