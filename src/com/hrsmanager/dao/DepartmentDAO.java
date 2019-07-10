package com.hrsmanager.dao;

import java.util.List;

import com.hrsmanager.model.DepartmentInfo;

public interface DepartmentDAO {

	public DepartmentInfo findDepartmentInfo(Integer department_id);
	public List<DepartmentInfo> listDeapartments();
}
