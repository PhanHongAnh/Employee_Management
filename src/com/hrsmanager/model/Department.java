package com.hrsmanager.model;

import java.sql.Timestamp;

public class Department {
	private Integer department_id;
	private String department_name;
	private String department_phone;
	private String department_address;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Timestamp deleted_at;
	
	
	public Integer getDepartmentID() {
		return department_id;
	}
	
	public String getDepartmentName() {
		return department_name;
	}
	
	public String getDepartmentAddress() {
		return department_address;
	}
	
	public String getDepartmentPhone() {
		return department_phone;
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
