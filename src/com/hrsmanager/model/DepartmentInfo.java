package com.hrsmanager.model;

import java.sql.Timestamp;

public class DepartmentInfo {

	private Integer departmentId;
	private String departmentName;
	private String departmentPhone;
	private String departmentAddress;
	private Timestamp created_at;
	private Timestamp updated_at;
	private boolean active;
	
	public DepartmentInfo(Integer department_id, String department_name) {
		this.departmentId = department_id;
		this.departmentName = department_name;
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
		this.active = true;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentPhone() {
		return departmentPhone;
	}

	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
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
