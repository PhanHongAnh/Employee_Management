package com.hrsmanager.model;

import java.sql.Date;
import java.sql.Timestamp;

public class EmployeeInfo {

	private Integer employee_id;
	private String employee_name;
	private String gender;
	private Date birthday;
	private String address;
	private String phone;
	private String email;
	private String password;
	private Date started_day;
	private Integer status_id;
	private Integer role_id;
	private Timestamp created_at;
	private Timestamp updated_at;
	private Integer department_id;
	private Integer position_id;
	
	public EmployeeInfo(Integer id, String name,String gender, Date birthday, String phone, String email, String password) {
		this.employee_id = id;
		this.employee_name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.password = id.toString();
		this.created_at = new Timestamp(System.currentTimeMillis());
		this.updated_at = this.created_at;
		this.password = String.valueOf(this.employee_id);
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
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
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
	
	public Integer getStatusID() {
		return status_id;
	}
	
	public void setStatusID(Integer status_id) {
		this.status_id = status_id;
	}
	
	public Integer getRoleID() {
		return role_id;
	}
	
	public void setRoleID(Integer role_id) {
		this.role_id = role_id;
	}
	
	public Timestamp getCreatedAt() {
		return created_at;
	}
	
	public void setCreateAt(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	public Timestamp getUpdatedAt() {
		return updated_at;
	}
	
	public void setUpdatedAt(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	
	public Integer getDepartmentID() {
		return department_id;
	}
	
	public void setDepartmentID(Integer department_id) {
		this.department_id = department_id;
	}
	
	public Integer getPositionID() {
		return position_id;
	}
	
	public void setPositionID(Integer position_id) {
		this.position_id = position_id;
	}
}
