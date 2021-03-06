package com.hrsmanager.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsmanager.dao.DepartmentDAO;
import com.hrsmanager.mapper.DepartmentMapper;
import com.hrsmanager.model.DepartmentInfo;

@Service
@Transactional
public class DepartmentDAOImpl extends JdbcDaoSupport implements DepartmentDAO{

	@Autowired
	public DepartmentDAOImpl (DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public List<DepartmentInfo> listDeapartments() {
		String sql = "Select * from Departments";
		return getJdbcTemplate().query(sql, new DepartmentMapper());
	}
	
	@Override
	public DepartmentInfo findDepartmentByID(Integer department_id) {
		String sql = "select * from Departments d where d.department_id = ?";
		Object[]params = new Object[] {department_id};
		DepartmentMapper mapper = new DepartmentMapper();
		try {
			DepartmentInfo depart = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return depart;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public DepartmentInfo findDepartmentByName(String department_name) {
		String sql = "select * from Departments d where d.department_name like %?%";
		Object[]params = new Object[] {department_name};
		DepartmentMapper mapper = new DepartmentMapper();
		try {
			DepartmentInfo depart = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return depart;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
