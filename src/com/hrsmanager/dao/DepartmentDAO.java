package com.hrsmanager.dao;

import java.util.List;

import com.hrsmanager.model.DepartmentInfo;

public interface DepartmentDAO {
	public List<DepartmentInfo> listDeapartments();
	public DepartmentInfo findDepartmentByID(Integer department_id);
	public DepartmentInfo findDepartmentByName(String department_name);
}
