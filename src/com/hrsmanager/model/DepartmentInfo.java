package com.hrsmanager.model;

import java.sql.Timestamp;

public class DepartmentInfo {

	private Integer department_id;
	private String department_name;
	private String department_phone;
	private String department_address;
	private Timestamp created_at;
	private Timestamp updated_at;
	private boolean active;
	
	public DepartmentInfo(Integer department_id, String department_name) {
		this.department_id = department_id;
		this.department_name = department_name;
		this.department_phone = "HRS";
		this.department_address = "adress HRS";
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
		this.active = true;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDepartment_phone() {
		return department_phone;
	}

	public void setDepartment_phone(String department_phone) {
		this.department_phone = department_phone;
	}

	public String getDepartment_address() {
		return department_address;
	}

	public void setDepartment_address(String department_address) {
		this.department_address = department_address;
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
