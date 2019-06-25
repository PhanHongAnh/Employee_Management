package com.hrsmanager.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Employee {
	private Integer employee_id;
	private String employee_name;
	private Date birthday;
	private String address;
	private String phone;
	private String email;
	private String password;
	private Date started_day;
	private String status;
	private String role;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Timestamp deleted_at;
	private Integer department_id;
	private Integer position_id;
	
	public Employee(Integer id, String name, Date birthday, String phone, String email) {
		this.employee_id = id;
		this.employee_name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.password = id.toString();
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
	}
	
	public Integer getEmployeeID() {
		return employee_id;
	}
	
	public void setEmployeeID(Integer id) {
		this.employee_id = id;
	}
	
	public String getEmployeeName() {
		return employee_name;
	}
	
	public void setEmployeeName(String name) {
		this.employee_name = name;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getStartedDay() {
		return started_day;
	}
	
	public void setStartedDay(Date started_day) {
		this.started_day = started_day;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Timestamp getCreatedAt() {
		return created_at;
	}
	
	public Timestamp getUpdatedAt() {
		return updated_at;
	}
	
	public void setUpdatedAt() {
		this.updated_at = new Timestamp(System.currentTimeMillis());
	}
	
	public Timestamp getDeletedAt() {
		return deleted_at;
	}
	
	public void setDeletedAt() {
		this.deleted_at = new Timestamp(System.currentTimeMillis());
	}
	
	public Integer getDepartmentID() {
		return department_id;
	}
	
	public void setDepartmentID(Integer id) {
		this.department_id = id;
	}
	
	public Integer getPositionID() {
		return position_id;
	}
	
	public void setPositionID(Integer id) {
		this.position_id = id;
	}
}
